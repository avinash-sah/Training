package practice.aug02;

/**
 * Count number of binary strings without consecutive 1’s for any length n.
 * <p>
 * Input: N = 3
 * Output: 5
 * The 5 strings are 000, 001, 010, 100, 101
 */
public class Q3_BinaryCons11 {
    public static void main(String[] args) {
        System.out.println(countStrings(4));
    }

    private static int countStrings(int pI) {
        int[] a = new int[pI + 1];
        int[] b = new int[pI + 1];
        a[1] = 1;
        b[1] = 1;

        for (int i = 2; i < pI; i++) {
            a[i] = a[i - 1] + b[i - 1];
            b[i] = a[i - 1];
        }
        return a[pI - 1] + b[pI - 1];
    }
}
