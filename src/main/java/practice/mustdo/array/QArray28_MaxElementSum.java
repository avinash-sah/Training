package practice.mustdo.array;

import java.util.Arrays;

public class QArray28_MaxElementSum {

    public static void main(String[] args) {
        int arr[] = {1, 60, -10, 70, -80, 85};
        int n = arr.length;
        minAbsSumPair(arr, n);
    }

    private static void minAbsSumPair(int[] pArr, int pN) {
        if (pN < 2) {
            System.out.println("Less than 2 elements");
            return;
        }

        Arrays.sort(pArr);
        int sum = 0;
        int minSum = Integer.MAX_VALUE;
        int l = 0;
        int r = pN - 1;

        int minL = 0;
        int minR = 0;

        while (l < r) {
            sum = pArr[l] + pArr[r];
            if (Math.abs(sum) < Math.abs(minSum)) {
                minSum = sum;
                minL = l;
                minR = r;
            }
            if (sum < 0) {
                l++;
            } else {
                r--;
            }
        }

        System.out.println("pair " + pArr[minL] + " + "+ pArr[minR] + " = " + minSum);
    }
}
