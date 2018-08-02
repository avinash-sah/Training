package practice.aug01;

/**
 * Write a program to print all permutations of a given string
 */
public class Q6_PermutationsString {
    public static void main(String[] args) {
        String s = "abc";
        permute(s, 0, s.length() - 1);
    }

    private static void permute(String pS, int pL, int pR) {
        if (pL == pR) {
            System.out.println(pS);
        } else {
            for (int i = pL; i <= pR; i++) {
                pS = swap(pS, pL, i);
                permute(pS, pL + 1, pR);
                pS = swap(pS, pL, i);
            }
        }
    }

    private static String swap(String pS, int pL, int pI) {
        char[] arr = pS.toCharArray();
        char temp = arr[pI];
        arr[pI] = arr[pL];
        arr[pL] = temp;
        return new String(arr);
    }
}
