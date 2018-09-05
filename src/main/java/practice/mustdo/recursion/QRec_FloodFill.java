package practice.mustdo.recursion;

public class QRec_FloodFill {

    public static final int M = 8;
    public static final int N = 8;

    public static void main(String[] args) {
        int screen[][] = {{1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 0, 0},
                {1, 0, 0, 1, 1, 0, 1, 1},
                {1, 2, 2, 2, 2, 0, 1, 0},
                {1, 1, 1, 2, 2, 0, 1, 0},
                {1, 1, 1, 2, 2, 2, 2, 0},
                {1, 1, 1, 1, 1, 2, 1, 1},
                {1, 1, 1, 1, 1, 2, 2, 1},
        };
        int x = 4, y = 4, newC = 3;
        floodFill(screen, x, y, newC);

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(screen[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void floodFill(int[][] pScreen, int pX, int pY, int pNewC) {
        int prev = pScreen[pX][pY];
        floodFillUtil(pScreen, pX, pY, pNewC, prev);
    }

    private static void floodFillUtil(int[][] pScreen, int pX, int pY, int pNewC, int pPrev) {
        if (pX < 0 || pX >= M || pY < 0 || pY >= N) {
            return;
        }
        if (pScreen[pX][pY] != pPrev) {
            return;
        }

        pScreen[pX][pY] = pNewC;

        floodFillUtil(pScreen, pX + 1, pY, pNewC, pPrev);
        floodFillUtil(pScreen, pX - 1, pY, pNewC, pPrev);
        floodFillUtil(pScreen, pX, pY - 1, pNewC, pPrev);
        floodFillUtil(pScreen, pX, pY + 1, pNewC, pPrev);
    }
}
