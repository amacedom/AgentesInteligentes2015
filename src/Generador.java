import java.util.ArrayList;
import java.util.List;


public class Generador {
	
	//Este metodo recibe el mestado inicial y al terminar regresa una lista de estados
	public List<Estado> crearEstados(Estado actual) {
		List<Estado> estados = new ArrayList<Estado>();
		boolean repetido;
		while((actual = generarEstado(actual)) != null) {
			repetido = estadoRepetido(estados,actual);
			if(!repetido)
				estados.add(actual);
		}
		
		return estados;
	}
	
	//Genera un estado que es el resultado de aplicar el operador al estado que mandamos
	public Estado generarEstado(Estado actual) {
		Estado nuevoEstado = new Estado();
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
			if(i.visitado)
				return true;
		}
		
		return false;
	}

}
