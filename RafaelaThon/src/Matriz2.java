public class Matriz2 {

	public static int tam=100;
	public static int tamBusca=2;
	public int matriz[][] = new int[tam][tam];
	public int matrizBusca[][] = new int[tamBusca][tamBusca];
	public int i,j;


	public void popularMatrizBusca() {
		matrizBusca[0][0] = 1;
		matrizBusca[0][1] = 1;
		matrizBusca[1][0] = 1;
		matrizBusca[1][1] = 0;

	}
	

	public void popularMatriz() {			
		for (i=0; i<tam; i++) {
			for(j=0; j<tam; j++) {
				matriz[i][j]=0;
			}
		}
		matriz[90][90]=1;
		matriz[90][91]=1;
		matriz[91][90]=1;
		matriz[91][91]=0;

	}
	
	public void imprimirMatriz() {
		for (i=0; i<tam; i++) {
			System.out.print("|");		
			for (j=0; j<tam; j++) {
				System.out.print(matriz[i][j]);
	     		System.out.print("|");
			}
			System.out.println(" ");
		}	
	}
	
	
	public boolean buscarMatriz() {
		long tempoInicial = System.nanoTime();
		//long tempoFinal = System.nanoTime();

		for(i=0; i<=98; i++) {
			for(j=0; j<=98; j++) {
				if ((matriz[i][j] == matrizBusca[0][0]) && (matriz[i][j+1] == matrizBusca[0][1])
						&& (matriz[i+1][j] == matrizBusca[1][0]) && (matriz[i+1][j+1] == matrizBusca[1][1])) {
					long	tempoFinal = System.nanoTime();
					System.out.println("A execu��o levou " + (tempoFinal - tempoInicial) + " nanos!");
					return true;
				}

			}
		}
		return false;
	}
}

