package algoritmos;

import java.util.ArrayList;
import java.util.List;

import rompecabezas.Estado;

public class BFS implements SearchMethods {
	
	List<Estado> estados;
	
	public BFS() {
		this.estados = new ArrayList<Estado>();
	}
	
	public BFS(List<Estado> estados) {
		this.estados = estados;
	}

	@Override
	public Estado buscarEstado(Estado objetivo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean existeEstado(Estado objetivo) {
		// TODO Auto-generated method stub
		return false;
	}

}
