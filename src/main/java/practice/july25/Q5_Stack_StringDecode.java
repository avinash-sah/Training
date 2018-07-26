package practice.july25;

import java.util.Stack;

public class Q5_Stack_StringDecode {

    public static void main(String[] args) {
        String encoded = "3[a3[b]1[ab]]";

        Stack<Character> stack  = new Stack<>();
        char d;
        for (int i = 0; i < encoded.length(); i++) {
            char c = encoded.charAt(i);
            if(Character.isLetterOrDigit(c)){
                stack.push(c);
            }else if(c == '['){
                stack.push(c);
            }else if(c == ']'){
                String s = "";
                while((d = stack.peek()) != '['){
                    s+= d;
                    stack.pop();
                }
                if(stack.peek() == '['){
                    stack.pop();
                }else{
                    System.out.println("invalid input");
                    return;
                }
                if(Character.isDigit(d = stack.pop())){
                    int re = d - '0';

                    for (int j = 0; j < re; j++) {
                        for (int k = s.length()-1; k >=0 ;k--) {
                            stack.push(s.charAt(k));
                        }
                    }
                }else{
                    System.out.println("invalid input");
                    return;
                }

            }
        }
        StringBuilder res = new StringBuilder();
        while (!stack.isEmpty()){
            res.append( stack.pop());
        }
        String actual = res.reverse().toString();
        System.out.println(actual.equals("abbbababbbababbbab"));
        System.out.println(actual);
    }
}
