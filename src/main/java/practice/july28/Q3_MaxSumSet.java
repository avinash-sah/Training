package practice.july28;

public class Q3_MaxSumSet {

    public static void main(String[] args) {
        int set[] = {3, 34, 4, 12, 5, 2};
        int sum = 9;
        int n = set.length;
        if (isSubsetSum(set, n, sum))
            System.out.println("Found a subset"
                    + " with given sum");
        else
            System.out.println("No subset with"
                    + " given sum");

        if (dyna_isSubsetSum(set, n, sum))
            System.out.println("Found a subset"
                    + " with given sum");
        else
            System.out.println("No subset with"
                    + " given sum");
    }

    private static boolean isSubsetSum(int[] pSet, int pN, int pSum) {

        if (pSum == 0) {
            return true;
        }
        if (pN == 0) {
            return false;
        }

        if (pSum < pSet[pN - 1]) {
            return isSubsetSum(pSet, pN - 1, pSum);
        }

        return isSubsetSum(pSet, pN - 1, pSum) ||
                isSubsetSum(pSet, pN - 1, pSum - pSet[pN - 1]);

    }

    private static boolean dyna_isSubsetSum(int[] pSet, int pN, int pSum) {
        boolean[][] set = new boolean[pSum + 1][pN + 1];

        for (int i = 0; i <= pSum; i++) {
            set[i][0] = true;
        }
        for (int i = 1; i <= pN; i++) {
            set[0][i] = false;
        }

        for (int i = 1; i <= pSum; i++) {
            for (int j = 1; j <= pN; j++) {
                if (i < pSet[j - 1]) {
                    set[i][j] = set[i][j - 1];
                } else {
                    set[i][j] =  set[i][j - 1] ||
                            set[i - pSet[j - 1]][j - 1];
                }
            }
        }
        return set[pSum][pN];
    }
}



