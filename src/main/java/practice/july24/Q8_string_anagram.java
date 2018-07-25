package practice.july24;

public class Q8_string_anagram {

    public static void main(String[] args) {
        String top = "gcd";
        String later = "cddgk";

        if(top.length() < later.length()){
            String temp = top;
            top = later;
            later = temp;
        }
        System.out.println(toAnagram(top, later));
    }

    private static int toAnagram(String pTop, String pLater) {

        int length = pTop.length();
        char[] hash = new char[length];
        int[] count = new int[length];
        for (int i = 0; i < length; i++) {
            hash[i] = pTop.charAt(i);
            count[i] = 0;
        }

        for (int i = 0; i < pLater.length(); i++) {
            for (int j = 0; j < length; j++) {
                if(pLater.charAt(i) == hash[j]){
                    count[j]++;
                    break;
                }
            }
        }

        int sum = 0;
        for (int i = 0; i < length; i++) {
            sum += count[i];
        }
        return length - sum;
    }
}
