package practice.aug01;

/**
 *  Given a binary string, count number of substrings that start and end with 1.
 *  For example, if the input string is “00100101”,
 *  then there are three substrings “1001”, “100101” and “101”.
 */
public class Q2_BinarySubString {
    public static void main(String[] args) {
        //Looks like Nc2 combination questions
        String s = "00100101";
        System.out.println(getSubstrings(s));
    }

    private static int getSubstrings(String pS) {
        int res = 0;
        for (int i = 0; i < pS.length(); i++) {
            if(pS.charAt(i) == '1'){
                res++;
            }
        }
        return (res * (res - 1) )/2;
    }
}
