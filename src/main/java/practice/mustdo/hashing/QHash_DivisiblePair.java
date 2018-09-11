package practice.mustdo.hashing;

import java.util.HashMap;
import java.util.Map;

public class QHash_DivisiblePair {

    public static void main(String[] args) {
        int arr[] = {92, 75, 65, 48, 45, 35};
        int k = 10;
        boolean ans = canPairs(arr, k);
        System.out.println(ans);

        int arr1[] = {91, 74, 66, 48};
        int k1 = 10;
        System.out.println(canPairs(arr1, k1));
    }

    private static boolean canPairs(int[] arr, int k) {
        if (arr.length % 2 != 0) {
            return false;
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.merge(arr[i] % k, 1, (a, b) -> a + b);
        }

        for (int i = 0; i < arr.length; i++) {
            int rem = k - arr[i] % k;
            Integer val = map.get(rem);
            if (val == null) {
                return false;
            }
            map.put(rem, val - 1);
            if (val - 1 != 0) {
                map.put(rem, val - 1);
            } else {
                map.remove(rem);
            }
        }

        return map.size() == 0;
    }
}
