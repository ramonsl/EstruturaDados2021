import java.util.Random;
import java.util.Scanner;
public class Aleatorie {
    public int igual = 0;
    int tam = 100;
    public int matriz[][] = new int[tam][tam];
    Random generator = new Random();
    int padrao[][] = new int[2][2];
    Scanner tc = new Scanner(System.in);


    public void montar() {
        for (int i = 0; i < tam; i++) {
            for (int j = 0; j < tam; j++) {
                matriz[i][j] = generator.nextInt(2);
            }
        }
    }

    public void padraoMonta(){
        for(int i=0; i<2;i++) {//inserindo o padrao
            for (int j = 0; j < 2; j++) {
                if ((i == 0) || (i == 0)) {
                    matriz[0][0] = 1;
                } else if ((i == 1) || (i == 0)) {
                    matriz[i][j] = 1;
                } else {
                    matriz[i][j] = 1;
                }
                if ((i == 1) || (i == 1)) {
                    matriz[1][1] = 0;
                } else {
                    matriz[i][j] = 1;
                }
            }
        }
/*        System.out.println("Insira a matriz de consulta");
        for(int entrada1=0; entrada1 < padrao.length; entrada1++){
            for(int entrada2=0; entrada2 < padrao[entrada1].length; entrada2++){
                padrao[entrada1][entrada2]= tc.nextInt();
            }
        }*/
    }

    public void buscaPadrao(){
        long tempoI = System.nanoTime();
        for (int teste1 = 0; teste1 < matriz.length-2; teste1++) { //coloquei menos 2 para ele não ultrapassar a matriz
            for (int teste2 = 0; teste2 < matriz[teste1].length-2; teste2++) { // mesma coisa vale
                if ((matriz[teste1][teste2] == 1) &&
                        (matriz[teste1][teste2+1] == 1) &&
                        (matriz[teste1+1][teste2] == 1)&&
                        (matriz[teste1+1][teste2+1] == 0)) {
                    igual++;
                    long tempoF = System.nanoTime();
                    System.out.println("\n\nTempo = " + (tempoF - tempoI) + " ms");

                    return;


                }
            }
        }if (igual > 0) {
            System.out.println("Existe padrão!" + igual);
        } else {
            System.out.println("Não existe padrão!" + igual);
        }
        //long tempoF = System.nanoTime();
        //System.out.println("\n\nTempo = " + (tempoF - tempoI) + " ms");

    }

    public void mostreAleatorio() {
        //pode comentar para aparecer o relógio sem poluição na tela
        System.out.println("Este é o aleatorio");
        for (int i = 0; i < tam; i++) {
            for (int j = 0; j < tam; j++) {
                System.out.print(matriz[i][j] + "|");
            }
        }

    }
}
