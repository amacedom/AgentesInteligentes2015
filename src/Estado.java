import java.util.ArrayList;
import java.util.List;


public class Estado {
	
	Object info;
	List<Estado> conexiones;
	boolean visitado;
	
	public Estado (Object info){ 
		this.info = info;
		this.visitado = false;	
		this.conexiones = new ArrayList<Estado>();
	}
}

