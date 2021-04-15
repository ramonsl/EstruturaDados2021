import java.util.Scanner;


/**
 * Main
 */
public class Main {
  static Matrix matrix = new Matrix(100);
  static byte[][] matrixTest = new byte[][] { { 1, 1 }, { 1, 0 } };

  public static void main(String[] args) {
    System.out.println("> Programa sendo inciado...");

    Scanner console = new Scanner(System.in);

    matrix.fillAuto();
    menu(console);

    console.close();

    System.out.println("\n> Programa encerrado.");
  }

  private static void menu(Scanner console) {
    System.out.print("\nEscolha uma opção\n" + "> 1 - Update matrix\n"
        + "> 2 - Preencher matrix com 1 com valor default\n" + "> 3 - Gerar nova matrix\n"
        + "> 4 - Setar matrix teste\n" + "> 5 - Buscar na matrix por todas a ocorrências\n"
        + "> 6 - Buscar na matrix por uma ocorrências\n" + "> 0 - Sair\n" + "> ");
    byte option = console.nextByte();

    switch (option) {
    case 1:
      Chronometer.clearMedia();
      matrix.fillAuto();
      break;

    case 2:
      Chronometer.clearMedia();
      matrix.fill(1);
      matrix.setDefault();
      break;

    case 3:
      System.out.print("Qual sera o tamanho da matrix: ");
      int size = console.nextInt();
      matrix = new Matrix(size);
      matrix.fillAuto();
      break;

    case 4:
      changeMatrixTest(console);
      break;

    case 5:
      System.out.println(matrix.searchDefaultAll(matrixTest));
      Chronometer.media();
      break;

    case 6:
      System.out.println(matrix.searchDefaultFirst(matrixTest));
      Chronometer.media();
      break;
    }

    if (option != 0) {
      menu(console);
    }
  }

  public static void changeMatrixTest(Scanner console) {
    System.out.print("Qual sera o tamanho da matrix (maxima: 4): ");
    int size = console.nextInt();

    if (size <= 4) {
      matrixTest = new byte[size][size];
      for (int rows = 0; rows < size; rows++)
        for (int cols = 0; cols < size; cols++) {
          System.out.print("Informe o valor para a posição [" + rows + "][" + cols + "] (somente 0 e 1): ");
          matrixTest[rows][cols] = console.nextByte();
          if (matrixTest[rows][cols] != 0 || matrixTest[rows][cols] != 1)
            matrixTest[rows][cols] = 0;
        }
    } else
      System.out.println("Valor informado invalido");
  }
}