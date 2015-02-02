package algoritmos;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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
		Queue<Estado> cola =  new LinkedList<Estado>();
		cola.add(this.estados.get(0));
		boolean cola_vacia = cola.isEmpty();
		
		while(!cola_vacia) {
			
			
			
			cola_vacia = cola.isEmpty();
		}
		
		
		return null;
	}

	@Override
	public boolean existeEstado(Estado objetivo) {
		// TODO Auto-generated method stub
		return false;
	}

}
