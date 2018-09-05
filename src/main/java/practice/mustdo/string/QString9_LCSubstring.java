package practice.mustdo.string;

public class QString9_LCSubstring {

    //not Longest common sub sequence,  need sub string

    public static void main(String[] args) {
        String X = "OldSite:GeeksforGeeks.org";
        String Y = "NewSite:GeeksQuiz.com";

        int m = X.length();
        int n = Y.length();

        System.out.println("Length of Longest Common Substring is "
                + LCSubStr(X.toCharArray(), Y.toCharArray(), m, n));
    }

    private static int LCSubStr(char[] pA, char[] pB, int pM, int pN) {
        int[][] LCString = new int[pM + 1][pN + 1];
        int max = 0;

        for (int i = 0; i < pM + 1; i++) {
            for (int j = 0; j < pN + 1; j++) {

                if (i == 0 || j == 0) {
                    LCString[i][j] = 0;
                } else if (pA[i - 1] == pB[j - 1]) {
                    LCString[i][j] = 1 + LCString[i - 1][j - 1];
                    max = Math.max(max, LCString[i][j]);
                } else {
                    LCString[i][j] = 0;
                }
            }

        }

        /*for (int i = 0; i <= pM ; i++) {
            for (int j = 0; j <= pN; j++) {
                System.out.print(LCString[i][j] +" ");
            }
            System.out.println();
        }*/

        return max;
    }
}
