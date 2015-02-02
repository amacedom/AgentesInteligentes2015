
public class Matriz {

	public int[][] moverArriba (int[][]actual) {
		int [][] nueva = actual;
		int filas = actual.length;
		int colum = actual[0].length;
		int valor; // cuando encontremos cero
		
		for(int i = 0; i < filas; i++) {
			for(int j = 0; j < colum; j++) {
				valor = actual[i][j];
				if(valor == 0) { // encontramos el cero, ahora hacemos la operacion de movernos hacia arriba
					try {
						int temp = nueva[i-1][j];
						nueva[i-1][j] = 0;
						nueva[i][j] = temp;
						
					} catch (ArrayIndexOutOfBoundsException e){
						System.out.println("la operacion no es posible, se sale de la matriz");
					}
				}
			}
		}
		
		return nueva;
	}
	
	public int[][] moverDerecha (int[][]actual) {
		int [][] nueva = actual;
		int filas = actual.length;
		int colum = actual[0].length;
		int valor; // cuando encontremos cero
		
		for(int i = 0; i < filas; i++) {
			for(int j = 0; j < colum; j++) {
				valor = actual[i][j];
				if(valor == 0) { // encontramos el cero, ahora hacemos la operacion de movernos hacia derecha
					try {
						int temp = nueva[i][j+1];
						nueva[i][j+1] = 0;
						nueva[i][j] = temp;
						
					} catch (ArrayIndexOutOfBoundsException e){
						System.out.println("la operacion no es posible, se sale de la matriz");
					}
				}
			}
		}
		
		return nueva;
	}
	
	public int[][] moverAbajo (int[][]actual) {
		int [][] nueva = actual;
		int filas = actual.length;
		int colum = actual[0].length;
		int valor; // cuando encontremos cero
		
		for(int i = 0; i < filas; i++) {
			for(int j = 0; j < colum; j++) {
				valor = actual[i][j];
				if(valor == 0) { // encontramos el cero, ahora hacemos la operacion de movernos hacia abajo
					try {
						int temp = nueva[i+1][j];
						nueva[i+1][j] = 0;
						nueva[i][j] = temp;
						
					} catch (ArrayIndexOutOfBoundsException e){
						System.out.println("la operacion no es posible, se sale de la matriz");
					}
				}
			}
		}
		
		return nueva;
	}
	
	public int[][] moverIzquierda (int[][]actual) {
		int [][] nueva = actual;
		int filas = actual.length;
		int colum = actual[0].length;
		int valor; // cuando encontremos cero
		
		for(int i = 0; i < filas; i++) {
			for(int j = 0; j < colum; j++) {
				valor = actual[i][j];
				if(valor == 0) { // encontramos el cero, ahora hacemos la operacion de movernos hacia izquierda
					try {
						int temp = nueva[i][j-1];
						nueva[i][j-1] = 0;
						nueva[i][j] = temp;
						
					} catch (ArrayIndexOutOfBoundsException e){
						System.out.println("la operacion no es posible, se sale de la matriz");
					}
				}
			}
		}
		
		return nueva;
	}
}
