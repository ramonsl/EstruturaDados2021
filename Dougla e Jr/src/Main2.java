import java.util.Random;

public class Main2 {
    public static void main(String[] args) {
        int l = 100;
        byte[][] m = new byte[l][l];
        byte[][] mp = new byte[][] { { 1, 1 }, { 1, 0 } };

        // Random random = new Random();

        for (int r = 0; r < l; r++)
            for (int c = 0; c < l; c++)
                m[r][c] = 0;

        m[90][90] = 1;
        m[90][91] = 1;
        m[91][90] = 1;
        m[91][91] = 0;

        long nanoTime = System.nanoTime();
        long nanoTimeFinal = 0;

        for (int r = 0; r < l; r++)
            for (int c = 0; c < l; c++)
                if ((m[r][c] == mp[0][0]) && (m[r][c + 1] == mp[0][1])  && (m[r + 1][c] == mp[1][0])  && (m[r + 1][c + 1] == mp[1][1])) {
                                nanoTimeFinal = System.nanoTime();
                                System.out.println("Nano time: " + (nanoTimeFinal - nanoTime));
                                return;
                            }

        System.out.println("Não achou");
    }
}
