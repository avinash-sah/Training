package practice.mustdo.string;

public class QString14_KMP {

    public static void main(String[] args) {
        String str = "abcxabcdabcdabcy";
        String subString = "abcdabcy";
        KMP(str.toCharArray(), subString.toCharArray());
    }

    private static void KMP(char[] pText, char[] pPattern) {

        int[] lps = createLps(pPattern);
        int i = 0;
        int j = 0;

        while (i < pText.length){
            if(pText[i] == pPattern[j]){
                i++;
                j++;
            }
            if(j == pPattern.length){
                System.out.println("found at " + (i -j));
                j = lps[ j -1];
            }else if(i < pText.length && pPattern[j] != pText[i]){
                if(j != 0){
                    j = lps[j -1];
                }else{
                    i++;
                }
            }
        }
    }

    private static int[] createLps(char[] pPattern) {
        int[] lps = new int[pPattern.length];
        lps[0] = 0;
        int index = 0;

        for (int i = 1; i < pPattern.length; ) {
            if (pPattern[i] == pPattern[index]) {
                index++;
                lps[i] = index;
                i++;
            } else {
                if (index != 0) {
                    index = lps[index - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;

    }
}
