package practice.aug01;

import java.util.HashMap;
import java.util.Stack;

public class Q8_Parentheses {
    public static void main(String[] args) {
        String exp = "[()]{}{[()()]()}";
        System.out.println(isOkay(exp));
        System.out.println(isOkay("[(])"));
    }

    private static boolean isOkay(String pExp) {
        Stack<Character> stack = new Stack<>();
        HashMap<Character, Character> charMap = new HashMap<>();
        charMap.put('}', '{');
        charMap.put(']', '[');
        charMap.put(')', '(');

        for (int i = 0; i < pExp.length(); i++) {
            char c = pExp.charAt(i);
            char d;
            switch (c) {
                case '[':
                case '{':
                case '(':
                    stack.push(c);
                    break;
                case ']':
                case '}':
                case ')':
                    char ex = charMap.get(c);
                   if(stack.isEmpty()){
                       return false;
                   }
                   if(stack.pop()!= ex){
                       return false;
                   }

            }
        }
        return true;
    }
}
