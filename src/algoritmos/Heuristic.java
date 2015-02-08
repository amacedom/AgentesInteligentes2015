package algoritmos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import rompecabezas.Estado;
import rompecabezas.Matriz;
import rompecabezas.Operador;

public class Heuristic implements SearchMethods {
	
	List<Estado> estados;
	
	public Heuristic() {
		this.estados = new ArrayList<Estado>();
	}
	
	public Heuristic(List<Estado> estados) {
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
		Queue<Estado> cola =  new LinkedList<Estado>();
		cola.add(this.estados.get(0));
		int[][] matriz_obj = (int[][])objetivo.getInfo();
		boolean cola_vacia = cola.isEmpty();
		
		while(!cola_vacia) {
			Estado head = cola.poll();
			//System.out.println("Estado padre => " + head.getNombre());
			List<Integer> total_mov = new ArrayList<Integer>();
			HashMap<Operador,Estado> enlaces = head.getEnlaces();
			HashMap<Integer,Estado> opciones = new HashMap<Integer,Estado>();
			for(Map.Entry <Operador,Estado> entry : enlaces.entrySet()) { // tenemos que calcular todos los movimientos para llegar a la solucion desde esta parte
				Estado hijo = entry.getValue();
				int[][] solucion_actual = (int[][])hijo.getInfo();
				/*System.out.println("actual:");
				hijo.verMatriz();
				System.out.println("solucion:");
				Matriz m = new Matriz();
				m.verMatriz(matriz_obj);*/
				int movimientos = calcularMovimientos(matriz_obj,solucion_actual);
				//System.out.println("\tdistancia total de " + hijo.getNombre() + " => "+ movimientos);
				total_mov.add(movimientos);
				opciones.put(movimientos, hijo);
			}
			
			if(!total_mov.isEmpty()) {
				Collections.sort(total_mov);
				//System.out.println(total_mov.get(0));
				cola.add(opciones.get(total_mov.get(0)));
			}
			
			int[][] matriz = (int[][])head.getInfo();
			boolean iguales = Arrays.deepEquals(matriz, matriz_obj);
			if(iguales) { //si encontro el estado deseado
				System.out.println("la solucion fue encontrada en el estado actual");
				head.verPropiedades();
				return true;
			}
			else { //no son iguales, sigamos buscando
				//System.out.println("la solucion no esta en el estado actual -> " + head.getNombre());
			}
			
			cola_vacia = cola.isEmpty();
		}
		

		return false;
	}
	
	public int calcularMovimientos(int[][] solucion,int[][]actual) {
		int filas = actual.length;
		int colum = actual[0].length;
		int movimientos = 0;
		int casilla = 0;
		
		for(int i = 0; i < filas; i++) {
			for(int j = 0; j < colum; j++ ) {
				casilla = manhattanDistance(solucion,actual,i,j);
				//System.out.println("movimientos de casilla " + casilla);
				movimientos += casilla;
			}
		}
		
		return movimientos;
	}
	
	/*Manhattan Distance*/
	public int manhattanDistance(int[][] solucion, int[][]actual, int fila, int col) {
		int i ,j = 0;
		int distancia = 0;
		int filas = actual.length;
		int colum = actual[0].length;
		int goal = actual[fila][col];
		int casilla_actual = -1;
		for(i = 0 ; i < filas; i++) {
			for(j = 0 ; j < colum; j++) {
				casilla_actual = solucion[i][j];
				if(casilla_actual == goal) {
					break;
				}
			}
			if(casilla_actual == goal) {
				break;
			}
			
 		}
		
		int operacion1 = (i - fila);
		int operacion2 = (j - col);
		distancia = Math.abs(operacion1) + Math.abs(operacion2);
		
		return distancia;
	}

}
