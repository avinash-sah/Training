package practice.mustdo.hashing;

public class QHash_UnCommonChar {

    public static final int MAX = 26;

    public static void main(String[] args) {
        String str1 = "characters";
        String str2 = "alphabets";
        findAndPrintUncommonChars(str1, str2);
    }

    private static void findAndPrintUncommonChars(String str1, String str2) {
        int[] position = new int[MAX];

        for (int i = 0; i < str1.length(); i++) {
            position[str1.charAt(i)-'a'] = 1;
        }

        for (int i = 0; i < str2.length(); i++) {
            int j = str2.charAt(i) - 'a';
            if(position[j] == 1 || position[j] == -1){
                position[j] = -1;
            }else{
                position[j] = 2;
            }
        }

        for (int i = 0; i < MAX; i++) {
            if(position[i] == 1 || position[i] == 2){
                System.out.print((char)(i + 'a') + " ");
            }
        }
    }
}
