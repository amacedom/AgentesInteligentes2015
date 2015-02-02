package rompecabezas;
import java.util.List;

import algoritmos.BFS;
import algoritmos.DFS;


public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int contador = 1;
		int[][] headbreaker = { {0,1},
								{4,3}};
		Estado s = new Estado(Integer.toString(contador),headbreaker);
		long tStart = System.currentTimeMillis();
		List<Estado> estados = new Generador().crearEstados(s);
		for(Estado i: estados) {
			i.verPropiedades();
		}
	
		long tEnd = System.currentTimeMillis();
		long tDelta = tEnd - tStart;
		double elapsedSeconds = tDelta / 1000.0;
		System.out.println("Elapsed Time: " + elapsedSeconds);
		
		System.out.println("busqueda por profundidad");
		DFS bus1 = new DFS(estados);
		bus1.buscarEstado(s);
		BFS bus2 = new BFS(estados);
		bus2.buscarEstado(s);
		
		System.out.println("busqueda por amplitud");
		
	}

}
