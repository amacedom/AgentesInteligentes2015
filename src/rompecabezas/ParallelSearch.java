package rompecabezas;

import java.util.Arrays;
import java.util.List;

public class ParallelSearch extends Driver implements Runnable {
	Thread hilo;
	Estado estado;
	int min,max;
	String nombreHilo;
	List<Estado> estados;
	
	ParallelSearch(int hilo,Estado estado,List<Estado> estados,int min, int max) {
		this.estado = estado;
		this.nombreHilo = Integer.toString(hilo);
		this.estados = estados;
		this.min = min;
		this.max = max;
		//System.out.println("Se creo Hilo -> " + this.nombreHilo);
	}
	
	public void run() {
		estadoRepetido();
		//go();
	}
	
	public synchronized void go() {
		try {
			System.out.println("Hilo -> " + this.nombreHilo + " corriendo");
			//Regresa un estado; el mísmo si es un estado nuevo y el estado original si no es nuevo.
			System.out.println("de " + this.min + " a " + this.max);
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		estadoRepetido();
	}
	
	public void estadoRepetido() {
		boolean equal;
		int exists = 0;
		for(int i = this.min; i < this.max; i++) {
			//System.out.println(i);
			equal = Arrays.deepEquals((Object[])this.estado.info,(Object[]) this.estados.get(i).info);
			if(equal){
				exists = 1;
				break;
			}
		}
		
		HILOS.put(this.nombreHilo, exists);
	}
	
	public void start(int numHilo) {
		//System.out.println("Se ejecutara Hilo -> " + this.nombreHilo);
		if(this.hilo == null) {
			this.hilo = new Thread();
		}
	}
	
	
	


}
