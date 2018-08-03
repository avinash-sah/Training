package practice.aug02;

/**
 * Given a boolean matrix (m*n) which is row wise sorted, give me the row with maximum number of 1s
 * <p>
 * Example
 * Input matrix
 * 0 1 1 1
 * 0 0 1 1
 * 1 1 1 1  // this row has maximum 1s
 * 0 0 0 0
 * <p>
 * Output: 2
 */

public class Q5_RowWithMax1 {
    public static void main(String[] args) {
        int[][] arr = {
                {0, 1, 1, 1},
                {0, 0, 1, 1},
                {1, 1, 1, 1},
                {0, 0, 0, 0}
        };

        int n = 4;
        int m = 4;

        System.out.println(getRow(arr, m, n));
    }

    private static int getRow(int[][] pArr, int pM, int pN) {
        int max = 0;
        int j = first(pArr[0], 0 , pM -1);
        if(j == -1){
            j = pM -1;
        }
        for (int i = 1; i < pN; i++) {
            while (j >= 0 && pArr[i][j] ==1){
                j--;
                max = i;
            }
        }
        return max;
    }

    private static int first(int[] pElements, int pL, int pH) {
        int index = -1;
        if (pL > pH) {
            return -1;
        }
        int mid = pL + (pH - pL) / 2;

        if ((mid == 0 || pElements[mid - 1] == 0) && pElements[mid] == 1) {
            return mid;
        } else if (mid == 0) {
            first(pElements, mid + 1, pH);
        } else {
            first(pElements, pL, mid - 1);
        }

        return index;
    }
}
