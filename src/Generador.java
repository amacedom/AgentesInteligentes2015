import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;


public class Generador {
	
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
			boolean repetido;
			actual = estados.get(index);// el estado con el que vamos a trabajar esta en la posicion index de la lista
			
			while(!vacio) { // mientras tengamos transiciones en el estado actual, generar estados con la transaccion actual
				Operador movimiento = transiciones.pop();
				Estado nuevoEnlace = generarEnlace(actual,movimiento);
				
				if(nuevoEnlace == null) { // no podemos movernos con este operador, cambiemos de operador haciendo un pop()
					System.out.println("ya no podemos movernos hacia " + movimiento);
				}
				else { // si no es nulo, entonces es un estado valido, pero no sabemos si es repetido
					repetido = estadoRepetido(estados,nuevoEnlace);
					if(!repetido) { // no esta repetido, por lo tanto lo agregamos a nuestra lista de estados
						actual.enlaces.put(movimiento, nuevoEnlace);
						estados.add(nuevoEnlace);
						nuevoEnlace.agregarNombre(contador);
						contador++;
					}
					else { // como este estado esta repetido debemos terminar
						System.out.println("el estado esta repetido");
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
		
		if(matriz) {
			switch(movimiento) {
				
				case ARRIBA:	System.out.println("Nos movemos hacia arriba");
								int [][] transicion = new Matriz().moverArriba((int[][])actual.info);
									
								break;
				
				case DERECHA:	System.out.println("Nos movemos hacia la derecha");
								break;
								
				case ABAJO: 	System.out.println("Nos movemos hacia abajo");
								break;
								
				case IZQUIERDA: System.out.println("Nos movemos hacia la izquierda");
								break;
			
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
