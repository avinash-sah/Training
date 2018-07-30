package practice.july28;

public class Q25_Anagram_permutation {

    private static final int MAX = 256;

    public static void main(String[] args) {
        String txt = "BACDGABCDA";
        String pat = "ABCD";
        search(txt, pat);
    }

    private static void search(String txt, String pat) {
        int[] count_pat = new int[MAX];
        int[] count_txt = new int[MAX];
        int l_txt = txt.length();
        int l_pat = pat.length();

        for (int i = 0; i < l_pat; i++) {
            (count_pat[pat.charAt(i)])++;
            (count_txt[txt.charAt(i)])++;
        }

        for (int i = 0; i < l_txt - l_pat; i++) {
            if (compare(count_pat, count_txt)) {
                System.out.println("Fount @ " + (i));
            }
            count_txt[txt.charAt(i)]--;
            count_txt[txt.charAt(i + l_pat)]++;
        }
        if (compare(count_pat, count_txt)) {
            System.out.println("Fount at " + (l_txt - l_pat));
        }

    }

    private static boolean compare(int[] pCount_pat, int[] pCount_txt) {
        for (int i = 0; i < MAX; i++) {
            if (pCount_pat[i] != pCount_txt[i]) {
                return false;
            }
        }
        return true;
    }


}
