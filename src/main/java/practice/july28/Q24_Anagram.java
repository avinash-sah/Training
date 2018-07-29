package practice.july28;

public class Q24_Anagram {
    public static void main(String[] args) {
        String s1 = "TRIANGLE";
        String s2 = "INTAGRAL";
        System.out.println(isAnagram(s1, s2));
    }

    private static boolean isAnagram(String pS1, String pS2) {
        if (pS1.length() != pS2.length()) {
            return false;
        }

        int[] counter = new int[256];
        for (int i = 0; i < pS1.length(); i++) {
            counter[pS1.charAt(i)]++;
            counter[pS2.charAt(i)]--;
        }
        for (int i = 0; i < counter.length; i++) {
            if (counter[i] != 0) {
                return false;
            }
        }

        return true;
    }
}
