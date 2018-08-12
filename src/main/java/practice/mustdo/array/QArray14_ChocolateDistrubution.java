package practice.mustdo.array;

import java.util.Arrays;

public class QArray14_ChocolateDistrubution {

    public static void main(String[] args) {
        int arr[] = {12, 4, 7, 9, 2, 23,
                25, 41, 30, 40, 28,
                42, 30, 44, 48, 43,
                50};

        int m = 7;  // Number of students

        int n = arr.length;
        System.out.println("Minimum difference is "
                + findMinDiff(arr, n, m));
    }

    private static int findMinDiff(int[] pArr, int pN, int pM) {
        if (pM == 0 || pN == 0) {
            return 0;
        }
        if (pN < pM) {
            return -1;
        }
        Arrays.sort(pArr);

        int min_diff = Integer.MAX_VALUE;
        int start = 0;
        int end = 0;

        for (int i = 0; i + pM - 1 < pN; i++) {
            int diff = pArr[i + pM - 1] - pArr[i];
            if (diff < min_diff) {
                min_diff = diff;
                start = i;
                end = i + pM - 1;

            }
        }

        for (int i = start; i <= end ; i++) {
            System.out.print(pArr[i] + " ");
        }
        System.out.println();
        return min_diff;
    }
}
