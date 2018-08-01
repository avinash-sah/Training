package practice.july29;

public class Q11_DnC_MaxSum {
    public static void main(String[] args) {
        int arr[] = {-2, -3, 4, -1, -2, 1, 5, -3};
        int n = arr.length;
        int max_sum = maxSubArraySum(arr, 0, n - 1);

        System.out.println("Maximum contiguous sum is " +
                max_sum);
        System.out.println("Maximum contiguous sum is " +
                maxSubArraySum_Kadane(arr));
    }

    private static int maxSubArraySum(int[] pArr, int pL, int pH) {

        if (pL == pH) {
            return pArr[pL];
        }

        int m = pL + (pH - pL) / 2;

        return Math.max(
                Math.max((maxSubArraySum(pArr, pL, m)), maxSubArraySum(pArr, m + 1, pH)),
                maxSumWithMid(pArr, pL, m, pH));
    }

    private static int maxSumWithMid(int[] pArr, int pL, int pM, int pH) {
        int lSum = Integer.MIN_VALUE;
        int rSum = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = pM; i >= pL; i--) {
            sum += pArr[i];
            if (sum > lSum) {
                lSum = sum;
            }
        }
        sum = 0;
        for (int i = pM + 1; i <= pH; i++) {
            sum += pArr[i];
            if (sum > rSum) {
                rSum = sum;
            }
        }
        return lSum + rSum;
    }


    static int maxSubArraySum_Kadane(int[] pArr) {
        int max_i = 0;
        int max_total = Integer.MIN_VALUE;
        int start = 0, end = 0;
        int s = 0;

        for (int i = 0; i < pArr.length; i++) {
            max_i += pArr[i];
            if (max_i > max_total) {
                max_total = max_i;
                start = s;
                end = i;
            }

            if (max_i < 0) {
                max_i = 0;
                s = i + 1;
            }
        }
        System.out.println("max " + start + " " + end + " " + max_total);
        return max_total;
    }
}
