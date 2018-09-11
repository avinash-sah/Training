package practice.mustdo.hashing;

import java.util.HashSet;
import java.util.Set;

public class QHash_FirstRepeating {
    public static void main(String[] args) {
        String str = "AlphaBeta";
        char[] arr = str.toCharArray();
        System.out.println(firstRepeating(arr));
    }

    private static char firstRepeating(char[] arr) {
        Set<Character> characters = new HashSet<>();
        for (char c: arr) {
            if(characters.contains(c)){
                return c;
            }else{
                characters.add(c);
            }
        }
        return 0;
    }
}
