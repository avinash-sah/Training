package practice.mustdo.stackQ;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class QStack_NextGreater {

    public static void main(String[] args) {
        int arr[] = {11, 13, 21, 3};
        printNGE(arr);
        printNGE(new int[]{13, 7, 6, 12});
    }

    private static void printNGE(int[] pArr) {
        Stack<Integer> stack = new Stack<>();
        Map<Integer, Integer> map = new HashMap<>();

        stack.push(pArr[0]);

        for (int i = 1; i < pArr.length; i++) {

            while (!stack.isEmpty() && stack.peek() < pArr[i]) {
                map.put(stack.peek(), pArr[i]);
                stack.pop();
            }
            stack.push(pArr[i]);
        }

        while (!stack.isEmpty()){
            map.put(stack.pop(), -1);
        }

        for (int i: pArr) {
            System.out.println(i  + " " + map.get(i));
        }
    }
}
