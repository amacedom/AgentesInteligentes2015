import java.util.List;


public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] headbreaker = { {1,2},
								{3,4}};
		Estado s = new Estado(headbreaker);
		List<Estado> estados = new Generador().crearEstados(s);
		for(Estado i: estados) {
			System.out.println("Estado: " + i.info);
		}
		
	}

}
