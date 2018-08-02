package practice.aug01;

/**
 * Given an array of integers, find length of the largest sub-Array with sum equals to 0.
 * <p>
 * Input: arr[] = {15, -2, 2, -8, 1, 7, 10, 23};
 * Output: 5
 * The largest sub-Array with 0 sum is -2, 2, -8, 1, 7
 */
public class Q10_ZeroSubArraySum {
    public static void main(String[] args) {
        int arr[] = {15, -2, 2, -8, 1, 7, 10, 23};
        int max_len = getMaxLenWithZeroSum(arr);
        System.out.println(max_len);
    }

    private static int getMaxLenWithZeroSum(int[] pArr) {
        int max_len = 0;
        for (int i = 0; i < pArr.length; i++) {
            int sum = 0;
            for (int j = i; j < pArr.length; j++) {
                sum += pArr[j];
                if (sum == 0) {
                    max_len = Math.max(max_len, j - i + 1);
                }
            }
        }
        return max_len;
    }
}
