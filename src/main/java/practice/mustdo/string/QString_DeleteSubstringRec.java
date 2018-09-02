package practice.mustdo.string;

import java.util.regex.Pattern;

public class QString_DeleteSubstringRec {

    public static void main(String[] args) {
    /*    System.out.println(maxMoves("ababa", "er") == 0); // Should be 0
        System.out.println(maxMoves("abaer", "er") == 1); // Should be 1
        System.out.println(maxMoves("erababa", "er") == 1); // Should be 1
        System.out.println(maxMoves("zzzeraba", "er") == 1); // Should be 1
        System.out.println(maxMoves("aerbabaer", "er") == 2); // Should be 2
        System.out.println(maxMoves("aeerra", "er") == 2); // Should be 2
        System.out.println(maxMoves("aerera", "er") == 2); // Should be 2
        System.out.println(maxMoves("aerbera", "er") == 2); //Should be 2
        System.out.println(maxMoves("aberebraba", "er") == 1); // Should be 1*/

        System.out.println(maxMoves("ababaa", "aba") == 2);
        System.out.println(_replaceLast("ababaa", "aba"));
    }

    static int maxMoves(String s, String t) {
        return Math.max(replaceFirst(s, t) , replaceLast(s, t));
    }

    private static int replaceLast(String s, String t) {
        String temp = s;
        int runningCount = 0;
        while(!(_replaceLast(temp, t).equals(temp))){
            temp = _replaceLast(temp, t);
            runningCount++;
        }
        return runningCount;
    }

    private static int replaceFirst(String s, String t) {
        String temp = s;
        int runningCount = 0;
        while(!(temp.replaceFirst(t, "").equals(temp))){
            temp = temp.replaceFirst(t, "");
            runningCount++;
        }
        return runningCount;
    }


    private static String _replaceLast(String s, String t){
        int index = s.lastIndexOf(t);
        if(index == -1){
            return s;
        }
        StringBuilder sb = new StringBuilder();
        if(index > 0){
            sb.append(s, 0, index);
        }

        if (index + t.length() < s.length()){
            sb.append(s, index + t.length(), s.length());
        }
        return sb.toString();
    }
}
