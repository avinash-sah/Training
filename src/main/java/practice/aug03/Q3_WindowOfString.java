package practice.aug03;

/**
 * Given a string x, find the minimum window in string x that contains all characters in another string y
 * Example: x= ADOBECODEBANC
 * y = ABC
 * OUTPUT: BANC
 * x= "this is a test string"
 * y = "tist"
 * OUTPUT: "t stri"
 */
public class Q3_WindowOfString {

    static final int MAX_CHAR = 256;

    public static void main(String[] args) {
        String str = "this is a test string";
        String pat = "tist";

        System.out.print("Smallest window is :  n" +
                findSubString(str, pat));
    }

    private static String findSubString(String pStr, String pPat) {
        int len1 = pStr.length();
        int len2 = pPat.length();

        if (len1 < len2) {
            return null;
        }
        int[] hashStr = new int[MAX_CHAR];
        int[] hashPat = new int[MAX_CHAR];

        for (int i = 0; i < len2; i++) {
            hashPat[pPat.charAt(i)]++;
        }

        int sIndex = -1;
        int start = 0;
        int minLength = Integer.MAX_VALUE;
        int count = 0;

        for (int i = 0; i < len1; i++) {
            hashStr[pStr.charAt(i)]++;

            if (hashPat[pStr.charAt(i)] != 0 &&
                    hashStr[pStr.charAt(i)] <= hashPat[pStr.charAt(i)]) {
                count++;
            }
            if (count == len2) {

                while (hashPat[pStr.charAt(start)] == 0 ||
                        hashPat[pStr.charAt(start)] < hashStr[pStr.charAt(start)]) {
                    if (hashPat[pStr.charAt(start)] < hashStr[pStr.charAt(start)]) {
                        start++;
                    }
                }

                int len = i - start + 1;
                if (minLength > len) {
                    minLength = len;
                    sIndex = start;
                }
            }

        }
        if (sIndex == -1) {
            return null;
        }

        return pStr.substring(sIndex, sIndex + minLength);

    }
}
