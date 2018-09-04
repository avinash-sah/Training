package practice.mustdo.stackQ;

import java.util.ArrayList;
import java.util.List;

public class Qq_FirstNonrepeating {

    public static void main(String[] args) {
        findFirstNonRepeatingChar("geeksforgeeksandgeeksquizfor");
    }

    private static void findFirstNonRepeatingChar(String stream) {
        boolean[] repeated = new boolean[256];
        List<Character> characters = new ArrayList<>();
        for (int i = 0; i < stream.length(); i++) {
            char c = stream.charAt(i);

            if (!repeated[c]) {
                if (!characters.contains(c)) {
                    characters.add(c);
                } else {
                    characters.remove((Character) c);
                    repeated[c] = true;
                }
            }

            if(characters.size() != 0){
                System.out.println(characters.get(0));
            }
        }


    }
}
