package practice.mustdo.array;

import java.util.HashMap;
import java.util.Map;

public class QArray24_LargestSubarrayBinary {

    public static void main(String[] args) {
        int arr[] = {1, 0, 0, 1, 0, 1, 1};
        printSubArray(arr);
    }

    private static void printSubArray(int[] pArr) {
        for (int i = 0; i < pArr.length; i++) {
            if (pArr[i] == 0) {
                pArr[i] = -1;
            }
        }

        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int max_len = 0;
        int start_index = 0;
        int end_index = 0;
        int sum_t = 0;
        int n = pArr.length;

        for (int i = 0; i < n; i++) {
            sum += pArr[i];
            if (sum == sum_t) {
                max_len = i + 1;
                end_index = i;
            }
            if (map.containsKey(sum - sum_t)) {
                if(max_len < i - map.get(sum -sum_t + n)){
                    max_len = i - map.get(sum -sum_t + n);
                    end_index = i;
                }
            } else {
                map.put(sum -sum_t + n, i);
            }

        }

        System.out.println((end_index - max_len + 1) + " " + end_index);


    }
}
