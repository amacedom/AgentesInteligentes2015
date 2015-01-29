import java.util.ArrayList;
import java.util.List;


public class Estado {
	
	Object info;
	List<Estado> conexiones;
	boolean visited;
	
	public Estado (Object info){ 
		this.info = info;
		this.visited = false;	
		this.conexiones = new ArrayList<Estado>();
	}
}

