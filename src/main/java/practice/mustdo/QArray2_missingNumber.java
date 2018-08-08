package practice.mustdo;

public class QArray2_missingNumber {

    public static void main(String args[])
    {
        int a[] = {1,2,4,5,6};
        int miss = getMissingNo(a,5);
        System.out.println(miss);
    }

    private static int getMissingNo(int[] pA, int pI) {
        int n = pI +1;
        int xor_i = 0;
        for (int i = 1; i <= n; i++) {
            xor_i ^= i;
        }

        int xor_c = 0;
        for (int i = 0; i < pI; i++) {
            xor_c ^= pA[i];
        }
        return xor_c ^ xor_i;
    }
}
