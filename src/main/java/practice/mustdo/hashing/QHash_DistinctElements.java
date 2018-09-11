package practice.mustdo.hashing;

import java.util.HashMap;
import java.util.Map;

public class QHash_DistinctElements {
    public static void main(String[] args) {
        int arr[] = {1, 2, 1, 3, 4, 2, 3};
        int k = 4;
        countDistinct(arr, k);
    }

    private static void countDistinct(int[] arr, int k) {

        Map<Integer, Integer> hash = new HashMap<>();

        for (int i = 0; i < k; i++) {
            hash.merge(arr[i], 1, (a, b) -> a + b);
        }
        System.out.println(hash.size());

        for (int i = k; i < arr.length; i++) {
            Integer h = hash.get(arr[i - k]);
            if (h == null || h == 1) {
                hash.remove(arr[i - k]);
            } else {
                hash.put(arr[i - k], h - 1);
            }

            hash.merge(arr[i], 1, (a, b) -> a + b);
            System.out.println(hash.size());
        }
    }
}
