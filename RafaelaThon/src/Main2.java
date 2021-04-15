public class Main2 {
	public static void main(String[] args) {
		
	Matriz2 matriz = new Matriz2();
	matriz.popularMatrizBusca();
	matriz.popularMatriz();
		if(matriz.buscarMatriz()) {
		System.out.println("achou");
		} else {
			System.out.println("n�o achou");	
		}
	//matriz.imprimirMatriz();
	}
}
