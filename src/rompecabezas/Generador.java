package rompecabezas;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;


public class Generador extends Driver {
	
	//Este metodo recibe el mestado inicial y al terminar regresa una lista de estados
	public List<Estado> crearEstados(Estado actual) {
		List<Estado> estados = new ArrayList<Estado>();
		int contador = 2;
		int index = 0;
		estados.add(actual); // tenemos que agregar el estado con el que iniciamos el problema
		// cuando alcanza el size de la lista es porque ya se analizaron todos los estados, nuestro algoritmo termina de procesar todos los estados posibles
		while(index < estados.size()) {
			// tenemos que inicializar todas nuestras posibles transiciones en el estado actual
			Stack<Operador> transiciones = initStack();
			boolean vacio = transiciones.isEmpty();
			boolean repetido = false;
			actual = estados.get(index);// el estado con el que vamos a trabajar esta en la posicion index de la lista
			
			if(estados.size() > 21160)
				numHilos = 6;
			else
				numHilos = 1;
			
			while(!vacio) { // mientras tengamos transiciones en el estado actual, generar estados con la transaccion actual
				Operador movimiento = transiciones.pop();
				Estado nuevoEnlace = generarEnlace(actual,movimiento);
				HILOS = new HashMap<String,Integer>();
				//System.out.println("probamos hacia -> " + movimiento);
				//System.out.println("estados tiene size -> " + estados.size());
				
				if(nuevoEnlace == null) { // no podemos movernos con este operador, cambiemos de operador haciendo un pop()
					//System.out.println("ya no podemos movernos hacia " + movimiento);
				}
				else { // si no es nulo, entonces es un estado valido, pero no sabemos si es repetido
					//System.out.println("se genero un estado valido");
					int min,max;
					int start = 0;
					List<Thread> threads = new ArrayList<Thread>();
					for(int hilo = 0 ; hilo < numHilos; hilo++) {
						min = start;
						if(hilo == (numHilos-1)) {
							max = estados.size()-1;
						}
						else {
							max = start + (estados.size()/numHilos)  ;
						}
						
						Thread t = new Thread(new ParallelSearch(hilo,nuevoEnlace, estados, min, max));
						start = max+1;
						threads.add(t);
						t.start();
					}
					
					for(int i = 0; i < threads.size(); i++){
						try {
							threads.get(i).join();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					
					//System.out.println("termino treads");
					for(Map.Entry <String,Integer> o: HILOS.entrySet()) {
						//System.out.print("Con: " + o.getKey() +  ", existe? ->  " + o.getValue());
						if(o.getValue() == 1){
							//System.out.println(" Si!");
							repetido = true;
							break;
						}
						else {
							repetido = false;
							//System.out.println();
						}
							
					}
					
					//repetido = estadoRepetido(estados,nuevoEnlace);
					if(!repetido) { // no esta repetido, por lo tanto lo agregamos a nuestra lista de estados
						//System.out.println("No esta repetido y se agregara a la lista de estados");
						actual.enlaces.put(movimiento, nuevoEnlace);
						estados.add(nuevoEnlace);
						System.out.println("estado numero -> " + contador);
						nuevoEnlace.agregarNombre(contador);
						contador++;
					}
					else { // como este estado esta repetido debemos terminar
						//System.out.println("el estado esta repetido");
	
					}		
					
				}
				vacio = transiciones.isEmpty();
			}
			index++; //ya se nos terminaron todas las transiciones para este estado, cambiemos al siguiente en la lista
		}
		
		return estados;
	}
	
	//Genera un estado que es el resultado de aplicar el operador al estado que mandamos, regresa null si es un estado invalido, de lo contrario regresa el enlace
	public Estado generarEnlace( Estado actual, Operador movimiento) {
		Estado estadoNuevo = null;
		boolean matriz = (actual.info instanceof int[][]);
		int [][] transicion = null; // la info del nuevo estado
		
		if(matriz) {
			switch(movimiento) {
				
				case ARRIBA:	//System.out.println("Nos movemos hacia arriba");
								transicion = new Matriz().moverArriba((int[][])actual.info);
									
								break;
				
				case DERECHA:	//System.out.println("Nos movemos hacia la derecha");
								transicion = new Matriz().moverDerecha((int[][])actual.info);
								
								break;
								
				case ABAJO: 	//System.out.println("Nos movemos hacia abajo");
								transicion = new Matriz().moverAbajo((int[][])actual.info);
								
								break;
								
				case IZQUIERDA: //System.out.println("Nos movemos hacia la izquierda");
								transicion = new Matriz().moverIzquierda((int[][])actual.info);
								
								break;
			
			}
			
			if(transicion == null) {
				//System.out.println("No pudimos generar ninguna transicion");
			}
			else {
				estadoNuevo = new Estado(transicion);
			}
			
		}
		
		return estadoNuevo;
	}
	
	//Regresa un estado; el mísmo si es un estado nuevo y el estado original si no es nuevo.
	public boolean estadoRepetido(List<Estado> estados, Estado estado) {
		for(Estado i: estados) {
			boolean equal = Arrays.deepEquals((Object[])estado.info,(Object[]) i.info);
			if(equal)
				return true;
		}
		
		return false;
	}
	
	private Stack<Operador> initStack() {
		Stack<Operador> initStack = new Stack<Operador>();
		initStack.push(Operador.IZQUIERDA);
		initStack.push(Operador.ABAJO);
		initStack.push(Operador.DERECHA);
		initStack.push(Operador.ARRIBA);
		
		return initStack;
	}

}
