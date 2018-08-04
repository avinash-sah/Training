package practice.aug02;

import java.util.HashMap;

/**
 * Give an finite list of integers (+ve,-ve) and a Number N, return true
 * if there is any subset that sums upto N, return false otherwise
 */
public class Q6_NegativeSumSubArray {
    public static void main(String[] args) {
        int arr[] = {13, 2, -2, -20, 10};
        int sum = -10;

        subArraySum(arr, sum);
    }

    private static void subArraySum(int[] pArr, int pSum) {
        HashMap<Integer, Integer> map = new HashMap<>();

        int curr_sum = 0;

        for (int i = 0; i < pArr.length; i++) {
            curr_sum += pArr[i];

            if (curr_sum == pSum) {
                System.out.println("Index 0 - " + i);
                return;
            }
            if (map.get(curr_sum - pSum) != null) {
                System.out.println("Index " + (map.get(curr_sum - pSum) + 1 )+ " - " + i);
                return;
            }

            map.put(curr_sum, i);
        }
    }


}
