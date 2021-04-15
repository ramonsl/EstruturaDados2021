import java.util.Random;

public class Matriz {

    int tamanhoMatriz = 100;
    int[][] matriz_normal = new int[tamanhoMatriz][tamanhoMatriz];
    int[][] numeroASerEncontrado = {{1, 1}, {1, 0}};
    int igual = 0;

    long tempoInicio;

    public void inserirMatriz() {


        Random gera = new Random();

        for (int i = 0; i < tamanhoMatriz; i++) {
            for (int j = 0; j < tamanhoMatriz; j++) {
                matriz_normal[i][j] = gera.nextInt(2);
            }
        }

    }

    public void mostrarMatriz() {

        System.out.println("\nMatriz gearda: \n");
        for (int i = 0; i < tamanhoMatriz; i++) {
            for (int b = 0; b < tamanhoMatriz; b++) {
                System.out.print(" " +matriz_normal[i][b]);
            }
            System.out.println(" ");
        }

    }

    public void procurarMatriz() {
        tempoInicio = System.nanoTime();

        for (int i = 0; i < matriz_normal.length-2; i++) {
            for (int j = 0; j < matriz_normal[i].length-2; j++) {
                if ((matriz_normal[i][j] == numeroASerEncontrado[0][0])
                        && (matriz_normal[i][j + 1] == numeroASerEncontrado[0][1])
                        && (matriz_normal[i + 1][j] == numeroASerEncontrado[1][0])
                        && (matriz_normal[i + 1][j + 1] == numeroASerEncontrado[1][1])) {
                    igual++;
                }
            }
        }
        
        if (igual > 0) {
            System.out.println("\nExiste padrão!");
        } else {
            System.out.println("\nNão existe padrão!");
        }

        System.out.println("Tempo Total em nano: "+(System.nanoTime()-tempoInicio));

    }

}
