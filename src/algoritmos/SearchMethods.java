package algoritmos;
import rompecabezas.Estado;

public interface SearchMethods {
	
	public Estado buscarEstado(Estado objetivo);
	
	public boolean existeEstado(Estado objetivo);

}
