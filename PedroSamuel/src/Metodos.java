import java.util.Random;

public class Metodos {

    Random random = new Random();
    boolean[][] padrao = new boolean[2][2];
    int tamanho = 100;
    boolean[][] matriz = new boolean[tamanho][tamanho];


    public void definirMatrizes(){
        //this.padrao = criarMatriz(this.padrao);
        this.padrao[0][0]=true;
        this.padrao[0][1]=true;
        this.padrao[1][0]=true;
        this.padrao[1][1]=false;
        this.matriz = criarMatriz(this.matriz);

        mostrarPadrao();
    }

    private boolean[][] criarMatriz(boolean[][] m){
        for(int i = 0; i<m.length; i++){
            for(int x = 0; x<m.length; x++){
                m[i][x] = random.nextBoolean();
            }
        }
        return m;
    }

    private void mostrarPadrao(){
        System.out.println("\nPadrão encontrado: ");

        for(int i = 0; i<this.padrao.length; i++){
            for(int x = 0; x<this.padrao.length;x++){
                if(x!=this.padrao.length-1){
                    System.out.print(this.padrao[i][x] + ", ");
                }else{
                    System.out.println(this.padrao[i][x]);
                }
            }

        }
    }

    public void encontrarPadrao(){
        int quant = 0;

        long startTime = System.nanoTime();
        for (int i = 0; i< this.matriz.length-1;i++) {
            for(int x = 0; x< this.matriz.length-1; x++){
                if(verificarPadrao(i,x)){
                    quant++;
                }
            }
        }
        long finalTime = System.nanoTime();

        System.out.println("O padrão foi encontrado " + quant + " vezes em "+ (finalTime - startTime) + " nanosegundos. ");
    }

    public void encontrarPadraoUmaVez(){

        long startTime = System.nanoTime();

        for (int i = 0; i< this.matriz.length-1;i++) {
            for(int x = 0; x< this.matriz.length-1; x++){
                if(verificarPadrao(i,x)){
                    break;
                }
            }
            break;
        }

        long finalTime = System.nanoTime();
        System.out.println("O padrão foi encontrado uma vez em "+ (finalTime - startTime) + " nanosegundos. ");
    }

    private boolean verificarPadrao(int i, int x){

        if(this.matriz[i][x] == padrao[0][0]){
            if(this.matriz[i][x+1] == padrao[0][1]){
                if(this.matriz[i+1][x] == padrao[1][0]){
                    if(this.matriz[i+1][x+1] == padrao[1][1]){
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
