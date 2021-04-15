package com.company;

import java.util.Random;
import java.util.Scanner;

public class Diego {

    int tamanho = 100;
    int[][] matriz = new int[tamanho][tamanho];
    Random random = new Random();
    long tempoFinal;
    long tempoInicial;
    long resultadoCronometro;

    // Preencher matriz com valores binários aleatórios
    public void menu() {
        for (int l = 0; l < matriz.length; l++) {
            for (int c = 0; c < matriz[l].length; c++) {
                matriz[l][c] = new Random().nextInt(2);
            }
        }
        mostrar();
    }

    private void iniciarCronometro() {
        tempoInicial = System.nanoTime();
    }

    private void pararCronometro() {
        tempoFinal = System.nanoTime();
        resultadoCronometro = (tempoFinal - tempoInicial);
        System.out.println("O tempo que levou em filtrar foi de " + (resultadoCronometro) + " nanosegundos");
    }

    // analisar em busca dos padrões em toda a matriz
    private void filtrarTodaMatriz() {
        int cont = 0;
        iniciarCronometro();
        for (int l = 0; l < tamanho; l++) {
            for (int c = 0; c < tamanho; c++) {
                if (l < tamanho - 1) {
                    if (c < matriz[l].length - 1) {
                        if (matriz[l][c] == 1 && matriz[l][c + 1] == 1) {
                            if (matriz[l + 1][c] == 1 && matriz[l + 1][c + 1] == 0) {
                                cont++;
                            }
                        }
                    }
                }
            }
        }
        pararCronometro();
        System.out.println("O padrão foi encontrado " + cont + " vezes");
    }

    //analisar em busca do primeiro padrão encontrado
    private void filtrarPrimeiroPadrao() {
        iniciarCronometro();
        for (int l = 0; l < tamanho; l++) {
            for (int c = 0; c < tamanho; c++) {
                if (l < tamanho - 1) {
                    if (c < matriz[l].length - 1) {
                        if (matriz[l][c] == 1 && matriz[l][c + 1] == 1) {
                            if (matriz[l + 1][c] == 1 && matriz[l + 1][c + 1] == 0) {
                                pararCronometro();
                                return;
                            }
                        }
                    }
                }
            }
        }
    }

    // Exibição de relatório
    private void mostrar() {
        Scanner tc = new Scanner(System.in);

        System.out.println("Digite 1 para filtrar toda a matriz");
        System.out.println("Digite 2 para encontrar o primeiro padrão");
        int opcao = tc.nextInt();

        switch (opcao) {
            case  1:
                filtrarTodaMatriz();
                break;
            case 2:
                filtrarPrimeiroPadrao();
                break;
            default:
                System.out.println("Opção inválida!");
        }
    }

}
