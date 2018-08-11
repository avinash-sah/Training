package practice.mustdo;

import java.util.Map;

public class QArray25_MaxIndex {
    public static void main(String[] args) {
        int arr[] = {9, 2, 3, 4, 5, 6, 7, 8, 18, 0};
        int n = arr.length;
        int maxDiff = maxIndexDiff(arr, n);
        System.out.println(maxDiff);
    }

    private static int maxIndexDiff(int[] pArr, int pN) {
        int[] LMin = new int[pN];
        int[] RMax = new int[pN];

        //Lmin
        LMin[0] = pArr[0];
        for (int i = 1; i < pN; i++) {
            LMin[i] = Math.min(LMin[i - 1], pArr[i]);
        }
        RMax[pN - 1] = pArr[pN - 1];
        for (int i = pN - 2; i >= 0; i--) {
            RMax[i] = Math.max(RMax[i + 1], pArr[i]);
        }

        int i = 0;
        int j = 0;
        int max_diff = -1;
        while (i < pN && j < pN) {
            if(LMin[i] < RMax[j]){
                max_diff = Math.max(max_diff, j -i);
                j++;
            }else {
                i++;
            }
        }

        return max_diff;
    }
}
