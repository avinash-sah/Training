package practice.mustdo;

public class QArray1_Kadane {

    public static void main(String[] args) {
        int a[] = {-2, -3, 4, -1, -2, 1, 5, -3};
        int n = a.length;
        maxSubArraySum(a, n);
    }

    private static void maxSubArraySum(int[] pA, int pN) {
        int max_so_far = Integer.MIN_VALUE;
        int max_ending_here = 0;
        int start = 0;
        int end = 0;
        int index = 0;

        for (int i = 0; i < pN; i++) {
            max_ending_here += pA[i];
            if (max_ending_here > max_so_far) {
                max_so_far = max_ending_here;
                start = index;
                end = i;
            }
            if (max_ending_here < 0) {
                max_ending_here = 0;
                index = i + 1;
            }
        }

        System.out.println(max_so_far + " " + start + "-"+end );
    }
}
