package practice.mustdo.array;

import java.util.Arrays;

public class QArray8_MinimumPlatform {

    public static void main(String[] args) {
        int arr[] = {900, 940, 950, 1100, 1500, 1800};
        int dep[] = {910, 1200, 1120, 1130, 1900, 2000};
        int n = arr.length;
        System.out.println("Minimum Number of Platforms Required = "
                + findPlatform(arr, dep, n));
    }

    private static int findPlatform(int[] pArr, int[] pDep, int pN) {
        Arrays.sort(pArr);
        Arrays.sort(pDep);

        int result = 1;
        int plat_needed = 1;
        int i = 1;
        int j = 0;

        while (i < pN && j < pN) {
            if (pArr[i] <= pDep[j]) {
                plat_needed++;
                i++;
                if (plat_needed > result) {
                    result = plat_needed;
                }
            } else {
                j++;
                plat_needed--;
            }
        }
        return result;
    }
}
