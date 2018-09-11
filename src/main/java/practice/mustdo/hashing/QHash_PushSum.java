package practice.mustdo.hashing;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class QHash_PushSum {
    public static void main(String[] args) {
        int arr1[] = {1, 0, -4, 7, 6, 4};
        int arr2[] = {0, 2, 4, -3, 2, 1};
        int x = 8;

        findPairs(arr1, arr2, x);
    }

    private static void findPairs(int[] arr1, int[] arr2, int x) {
        Map<Integer, Integer> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();

        for (int a : arr1) {
            set.add(a);
        }

        for (int a : arr2) {
            if (set.contains(x - a)) {
                System.out.println((x - a) + " " + a);
            }
        }
    }
}
