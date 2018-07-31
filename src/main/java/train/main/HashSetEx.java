package train.main;

import java.util.HashSet;

public class HashSetEx {
    public static void main(String[] args) {
        HashSet<String> strings = new HashSet<>();
        String s = "abc1234";
        String s1 = new String("abc1234");

        strings.add(s);
        strings.add(s1);
        System.out.println(s.hashCode() == s1.hashCode());

        System.out.println(strings.size());

        char a = 'a';
        System.out.println((int)'A');
        System.out.println((int)'Z');
        System.out.println((int)'a');
        System.out.println((int)'z');
    }
}
