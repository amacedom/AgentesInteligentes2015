import java.util.List;


public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int contador = 1;
		int[][] headbreaker = { {0,1},
								{2,3},
								{4,5},
								{6,7}};
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
	}

}
