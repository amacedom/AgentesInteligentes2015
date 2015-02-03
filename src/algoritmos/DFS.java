package algoritmos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

import rompecabezas.Estado;
import rompecabezas.Operador;

public class DFS implements SearchMethods{
	
	List<Estado> estados;
	
	public DFS() {
		this.estados = new ArrayList<Estado>();
	}
	
	public DFS(List<Estado> estados) {
		this.estados = estados;
	}
	
	@Override
	public Estado buscarEstado(Estado objetivo) {
		// TODO Auto-generated method stub
		Stack<Estado> pila =  new Stack<Estado>();
		pila.push(this.estados.get(0));
		int[][] matriz_obj = (int[][])objetivo.getInfo();
		boolean pila_vacia = pila.isEmpty();
		
		while(!pila_vacia) {
			Estado head = pila.pop();
			HashMap<Operador,Estado> enlaces = head.getEnlaces();
			for(Map.Entry <Operador,Estado> entry : enlaces.entrySet()) { //tenemos que agregar todos los estados a este nivel del arbol directamente a la cola
				if(!entry.getValue().visitado())
					pila.push(entry.getValue());
				else {
					System.out.println("El estado " + head.getNombre() + "ya esta visitado");
				}
			}
			int[][] matriz = (int[][])head.getInfo();
			boolean iguales = Arrays.deepEquals(matriz, matriz_obj);
			if(iguales) { //si encontro el estado deseado
				System.out.println("la solucion fue encontrada en el estado actual");
				head.verPropiedades();
				return head;
			}
			else { //no son iguales, sigamos buscando
				System.out.println("la solucion no esta en el estado actual -> " + head.getNombre());
			}
			head.setVisitado(true);
			pila_vacia = pila.isEmpty();
		}
		
		return null;
	}

	@Override
	public boolean existeEstado(Estado objetivo) {
		// TODO Auto-generated method stub
		Stack<Estado> pila =  new Stack<Estado>();
		pila.push(this.estados.get(0));
		int[][] matriz_obj = (int[][])objetivo.getInfo();
		boolean pila_vacia = pila.isEmpty();
		
		while(!pila_vacia) {
			Estado head = pila.pop();
			HashMap<Operador,Estado> enlaces = head.getEnlaces();
			for(Map.Entry <Operador,Estado> entry : enlaces.entrySet()) { //tenemos que agregar todos los estados a este nivel del arbol directamente a la cola
				if(!entry.getValue().visitado())
					pila.push(entry.getValue());
				else {
					System.out.println("El estado " + head.getNombre() + "ya esta visitado");
				}
			}
			int[][] matriz = (int[][])head.getInfo();
			boolean iguales = Arrays.deepEquals(matriz, matriz_obj);
			if(iguales) { //si encontro el estado deseado
				System.out.println("la solucion fue encontrada en el estado actual");
				head.verPropiedades();
				return true;
			}
			else { //no son iguales, sigamos buscando
				System.out.println("la solucion no esta en el estado actual -> " + head.getNombre());
			}
			head.setVisitado(true);
			pila_vacia = pila.isEmpty();
		}
		
		return false;
	}

}
