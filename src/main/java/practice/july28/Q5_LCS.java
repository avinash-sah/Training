package practice.july28;

public class Q5_LCS {
    public static void main(String[] args) {
        String s1 = "AGGTAB";
        String s2 = "GXTXAYB";

        String a = "OldSite:GeeksforGeeks.org";
        String b = "NewSite:GeeksQuiz.com";

        char[] X = s1.toCharArray();
        char[] Y = s2.toCharArray();
        int m = X.length;
        int n = Y.length;
        System.out.println(lcs_r(X, Y, m, n));
        System.out.println(lcs(X, Y, m, n));

        
        System.out.println("Length of Longest Common Substring is "
                + lcs(s1.toCharArray(), s2.toCharArray(), s1.length(), s2.length()));
    }

    static int lcs_r(char[] x, char[] y, int m, int n) {

        if (m == 0 || n == 0) {
            return 0;
        }
        if (x[m - 1] == y[n - 1]) {
            return 1 + lcs_r(x, y, m - 1, n - 1);
        } else {
            return Math.max(lcs_r(x, y, m, n - 1), lcs_r(x, y, m - 1, n));
        }
    }

    static int lcs(char[] x, char[] y, int m, int n) {

        int[][] L = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0) {
                    L[i][j] = 0;
                } else if (x[i - 1] == y[j - 1]) {
                    L[i][j] = 1 + L[i - 1][j - 1];
                } else {
                    L[i][j] = Math.max(L[i - 1][j], L[i][j - 1]);
                }
            }
        }


        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                System.out.print(L[i][j] + " ");
            }
            System.out.println();
        }

        return L[m][n];
    }
}
