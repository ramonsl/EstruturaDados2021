import java.util.Random;

public class Matriz {

    int t = 100;
    int[][] matriz = new int[t][t];
    int padrao = 0;
    long temp;





    public void prencherMatriz() {
        for (int i = 0; i < t; i++) {
            for (int n = 0; n < t; n++) {
                matriz[i][n] = new Random().nextInt(2);
            }
        }
    }

    public void buscarPadrao() {
        long tempoInicial = System.nanoTime();
       for (int i = 0; i < t-1; i++) {
           for (int n = 0; n < t - 1; n++){
               if (matriz[i][n] == 1 && matriz[i + 1][n] == 1 && matriz[i][n + 1] == 1 && matriz[i + 1][n + 1] == 0) {
                   long tempoFinal = System.nanoTime();
                   temp =  tempoFinal - tempoInicial;
                   return;
               }
           }
           }
       }




    public void mostrarMatriz() {
        System.out.println(">> Matriz");
        for (int i = 0; i < t; i++) {
            for (int n = 0; n < t; n++)
                System.out.print(matriz[i][n] + " ");
            System.out.println();
            }
        }


        public void mostrarPatrao(){
            int p=2;
            int pp[][]= new int[p][p];
            pp[0][0]=1;
            pp[0][1]=1;
            pp[1][0]=1;
            pp[1][1]=0;
            System.out.println(">> Padrao a buscar da Matriz");
            for (int i = 0; i < p; i++) {
                for (int n = 0; n < p; n++)
                    System.out.print(pp[i][n] + " ");

                System.out.println();
            }

            System.out.println(">> Padrões encontrados <<");
            System.out.println("Padrão: " + padrao);
            System.out.println( temp + " nano");

        }

}


