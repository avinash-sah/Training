package practice.mustdo.string;

public class QString_DeletingSubstring {

    public static void main(String[] args) {
        System.out.println(maxMoves("aabb" , "ab"));
        System.out.println(maxMoves("aabcbdc" , "abc"));
        System.out.println(maxScore("ababaa", "aba"));

        System.out.println(maxScore("ababa", "er") == 0); // Should be 0
        System.out.println(maxScore("abaer", "er") == 1); // Should be 1
        System.out.println(maxScore("erababa", "er") == 1); // Should be 1
        System.out.println(maxScore("zzzeraba", "er") == 1); // Should be 1
        System.out.println(maxScore("aerbabaer", "er") == 2); // Should be 2
        System.out.println(maxMoves("aeerra", "er") == 2); // Should be 2
        System.out.println(maxMoves("aerera", "er")); // Should be 2
        System.out.println(maxMoves("aerbera", "er") == 2); //Should be 2
        System.out.println(maxMoves("aberebraba", "er") == 1); // Should be 1
    }

    static int maxMoves(String s, String t) {
        int count = 0;
        while(s.contains(t))
        {
            s = s.replace(t,"");
            ++count;
        }

        return count;
    }

    public static int maxScore(String bigString, String littleString){
        String tempString = bigString;
        int runningCount = 0;
        while(!(tempString.replaceFirst(littleString, "").equals(tempString))){
            tempString = tempString.replaceFirst(littleString, "");
            runningCount++;
        }
        return runningCount;
    }

}
