package practice.mustdo;

public class QArray21_SpiralMatrix {

    public static void main(String[] args) {
        int R = 3;
        int C = 6;
        int a[][] = { {1,  2,  3,  4,  5,  6},
                {7,  8,  9,  10, 11, 12},
                {13, 14, 15, 16, 17, 18}
        };
        spiralPrint(R,C,a);
    }

    private static void spiralPrint(int pR, int pC, int[][] pA) {
        int row = 0;
        int col = 0;

        while (row < pR && col < pC){
            for (int i = col; i < pC; i++) {
                System.out.print(pA[row][i] + " ");
            }
            row++;

            for (int i = row ; i < pR; i++) {
                System.out.print(pA[i][pC-1] + " ");
            }
            pC--;

            if(row < pR){
                for (int i = pC -1; i >= col; i--) {
                    System.out.print(pA[pR-1][i] + " ");
                }
                pR--;
            }

            if(col < pC){
                for (int i = pR-1; i >= row ; i--) {
                    System.out.print(pA[i][col] +" ");
                }
                col++;
            }
        }
    }
}
