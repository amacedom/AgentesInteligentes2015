import java.util.HashMap;

public class Estado {
	
	Object info;
	HashMap<Operador,Estado>enlaces;
	boolean visitado;
	
	public Estado() {
		this.info = null;
		this.visitado = false;
		this.enlaces = new HashMap<Operador,Estado>();
	}
	
	public Estado (Object info){ 
		this.info = info;
		this.visitado = false;	
		this.enlaces = new HashMap<Operador,Estado>();
	}
	
	public void agregarEnlace(Operador operador,Estado estadoDestino) {
		this.enlaces.put(operador, estadoDestino);
	}
}

