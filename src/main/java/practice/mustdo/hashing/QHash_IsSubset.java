package practice.mustdo.hashing;

import java.util.HashSet;
import java.util.Set;

public class QHash_IsSubset {
    public static void main(String[] args) {
        int arr1[] = {11, 1, 13, 21, 3, 7};
        int arr2[] = {11, 3, 7, 1};

        if (isSubset(arr1, arr2))
            System.out.println("arr2 is a subset of arr1");
        else
            System.out.println("arr2 is not a subset of arr1");
    }

    private static boolean isSubset(int[] arr1, int[] arr2) {

        Set<Integer> set = new HashSet<>();
        for (int a : arr1) {
            if (!set.contains(a)) {
                set.add(a);
            }
        }

        for (int a : arr2) {
            if (!set.contains(a)) {
                return false;
            }
        }
        return true;
    }
}
