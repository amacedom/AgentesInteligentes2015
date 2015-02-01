import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;


public class Generador {
	
	//Este metodo recibe el mestado inicial y al terminar regresa una lista de estados
	public List<Estado> crearEstados(Estado actual) {
		List<Estado> estados = new ArrayList<Estado>();
		int contador = 2;
		
		// esto es porque cuando actual se vuelve nulo, nuestro algoritmo termina de procesar todos los estados posibles
		while(actual != null) {
			// tenemos que inicializar todas nuestras posibles transiciones en el estado actual
			Stack<Operador> transiciones = initStack();
			boolean vacio = transiciones.isEmpty();
			boolean repetido;
			while(!vacio) {
				// mientras tengamos transiciones en el estado actual, generar estados con la transaccion actual
				Operador movimiento = transiciones.pop();
				Estado nuevoEnlace = generarEnlace(actual,movimiento);
				
				if(nuevoEnlace == null) {
					// no podemos movernos con este operador, cambiemos de operador haciendo un pop()
					System.out.println("ya no podemos movernos hacia " + movimiento);
				}
				else {
					// si no es nulo, entonces es un estado valido, pero no sabemos si es repetido
					repetido = estadoRepetido(estados,nuevoEnlace);
					if(!repetido) {
						// no esta repetido, por lo tanto lo agregamos a nuestra lista de estados
						estados.add(nuevoEnlace);
						nuevoEnlace.agregarNombre(contador);
						contador++;
					}
					else {
						// como este estado esta repetido debemos terminar 
						System.out.println("el estado esta repetido");
					}		
				}	
			}
			
		}
		
		return estados;
	}
	
	public Estado generarEnlace( Estado actual, Operador movimiento) {
		Estado estadoNuevo = null;
		
		
		
		return estadoNuevo;
	}
	
	//Genera un estado que es el resultado de aplicar el operador al estado que mandamos
	public Estado generarEstado(Estado actual) {
		Estado nuevoEstado = null; //esta es mi condicion de paro, el hecho de que no se pueda crear un estado regresa nullo
		int numEnlaces = actual.enlaces.size();
		if(numEnlaces <= 2 ) {
			
		}
		
		return nuevoEstado;
	}
	
	//Regresa verdadero o falso si el estado es valido o inválido
	public boolean estadoValido(Estado estado) {
		
			
		return false;
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
