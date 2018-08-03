package practice.aug02;

import java.util.Arrays;
import java.util.Comparator;

/**
 * input - apt, won, pat, now, tap
 * output - apt, pat, tap, won, now
 * n words of m letters
 * Bring all permutations together
 */

public class Q1_AllPermutations {

    public static void main(String[] args) {
        String[] strings = {"apt", "won", "pat", "now", "tap"};
        Word[] words = new Word[strings.length];
        for (int i = 0; i < strings.length; i++) {
            words[i] = new Word(strings[i], i);

        }

        //sort all the strings in word

        for (Word word : words) {
            char[] chars = word.str.toCharArray();
            Arrays.sort(chars);
            word.str = new String(chars);
        }

        //sort all the words

        Arrays.sort(words, Comparator.comparing(pO -> pO.str));

        //print the strings based on new index
        for (Word word: words) {
            System.out.print( strings[word.index]+" ");
        }

    }

    static class Word {
        String str;
        int index;

        public Word(String pStr, int pIndex) {
            str = pStr;
            index = pIndex;
        }
    }
}
