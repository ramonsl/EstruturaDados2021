public class Matrix {
  int width;
  byte[][] matrix;

  public Matrix(int width) {
    this.width = width;
    this.matrix = new byte[width][width];
  }

  public void fill(int value) {
    for (int row = 0; row < this.width; row++) {
      for (int col = 0; col < this.width; col++) {
        this.matrix[row][col] = (byte) value;
      }
    }
  }

  public void fillAuto() {
    System.out.println("\n> Preenchendo matrix...");
    for (int row = 0; row < this.width; row++) {
      for (int col = 0; col < this.width; col++) {
        this.matrix[row][col] = (byte) Math.round(Math.random());
      }
    }
  }

  public void setDefault() {
    this.matrix[98][0] = 1;
    this.matrix[98][1] = 1;
    this.matrix[99][0] = 1;
    this.matrix[99][1] = 0;

    this.matrix[98][98] = 1;
    this.matrix[98][99] = 1;
    this.matrix[99][98] = 1;
    this.matrix[99][99] = 0;
  }

  public String searchDefaultAll(byte[][] m) {
    byte s = (byte) m.length;
    int d = 0;
    int ws = this.width - s;

    Chronometer.start();
    for (int r = 0; r < ws; r++) {
      for (int c = 0; c < ws; c++) {
        if (matrix[r][c] == m[0][0])
          if (find(m, s, r, c) == 1)
            d++;
      }
    }

    Chronometer.stop();
    return "Houve um total de " + d;
  }

  public String searchDefaultFirst(byte[][] m) {
    byte s = (byte) m.length;
    int ws = this.width - s;

    Chronometer.start();
    for (int r = 0; r < ws; r++) {
      for (int c = 0; c < ws; c++) {
        if (matrix[r][c] == m[0][0]) {
          if (find(m, s, r, c) == 1) {
            Chronometer.stop();
            return "Padrão localizado";
          }
        }
      }
    }

    Chronometer.stop();
    return "Padrão não localizado";
  }

  public byte find(byte[][] m, byte s, int r, int c) {
    for (byte i = 0; i < s; i++)
      for (byte j = 0; j < s; j++)
        if (matrix[r + i][c + j] != m[i][j])
          return 0;

    return 1;
  }

}