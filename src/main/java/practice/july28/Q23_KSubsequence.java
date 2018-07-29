package practice.july28;

public class Q23_KSubsequence {

    private static final int CHAR_SIZE = 26;

    public static void main(String[] args) {
        String str = "aabbaabacabb";
        int k = 5;
        longestSubseqWithK(str, k);
    }

    private static void longestSubseqWithK(String pStr, int pK) {
        int[] chars = new int[CHAR_SIZE];
        for (int i = 0; i < CHAR_SIZE; i++) {
            chars[i] = 0;
        }

        for (int i = 0; i < pStr.length(); i++) {
            char c = pStr.charAt(i);
            chars[c - 'a']++;
        }

        for (int i = 0; i < pStr.length(); i++) {
            if (chars[pStr.charAt(i) - 'a'] >= pK) {
                System.out.print(pStr.charAt(i));
            }
        }
        System.out.println();
    }
}
