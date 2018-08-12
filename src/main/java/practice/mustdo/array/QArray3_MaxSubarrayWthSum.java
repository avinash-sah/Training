package practice.mustdo.array;

import java.util.HashMap;

public class QArray3_MaxSubarrayWthSum {

    public static void main(String[] args) {
        int arr[] = {15, 2, 4, 8, 9, 5, 10, 23};
        int n = arr.length;
        int sum = 23;
        subArraySum(arr, sum);

        int arr2[] = {10, 2, -2, -20, 10};
        subArraySum(arr2, -10);
    }

    private static void subArraySum(int[] pArr, int pSum) {
        int pN = pArr.length;
        HashMap<Integer, Integer> map = new HashMap<>();

        int curr_sum = 0;

        for (int i = 0; i < pN; i++) {
            curr_sum += pArr[i];

            if (curr_sum == pSum) {
                System.out.println("index 0 - " + i);
                return;
            }

            if (map.get(curr_sum - pSum) != null) {
                System.out.println("index " + (map.get(curr_sum - pSum) + 1) + " - " + i);
                return;
            }

            map.put(curr_sum, i);
        }
    }
}
