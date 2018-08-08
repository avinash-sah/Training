package practice.aug03;

/**
 * Find the maximum repeating number in O(n) time and O(1) extra space
 * Given an array of size n, the array contains numbers in range from 0 to k-1 where k is a positive integer and k <= n.
 * Find the maximum repeating number in this array.
 * For example, let k be 10 the given array be arr[] = {1, 2, 2, 2, 0, 2, 0, 2, 3, 8, 0, 9, 2, 3},
 * the maximum repeating number would be 2.
 * Expected time complexity is O(n) and extra space allowed is O(1).
 * Modifications to array are allowed.
 */
public class Q1_MaxRepeatingNumber {
    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 2, 0, 2, 0, 2, 3, 8, 0, 9, 2, 3};
        int k = 10;
        findMaxRepeatingNo(arr, k);
    }

    private static void findMaxRepeatingNo(int[] pArr, int k) {

        for (int i = 0; i < pArr.length; i++) {
            pArr[pArr[i] % k] +=  k;
        }

        int max_ind = 0;
        int max = 0;
        for (int i = 0; i < pArr.length; i++) {
            if(pArr[i] > max){
                max = pArr[i];
                max_ind = i;
            }
        }
        System.out.println(max_ind);

    }
}
