package practice.mustdo.recursion;

public class QRec_TotalPath {
    public static void main(String[] args) {
        System.out.println(numberOfPaths(3, 3));
    }

    private static int numberOfPaths(int m, int n) {
        int[][] table = new int[m][n];

        for (int i = 0; i < m; i++) {
            table[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            table[0][i] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                table[i][j] = table[i-1][j]+table[i][j-1];
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(table[i][j]);
            }
            System.out.println();
        }
        return table[m-1][n-1];
    }
}
