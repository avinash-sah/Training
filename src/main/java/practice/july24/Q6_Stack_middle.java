package practice.july24;

import java.util.Stack;

public class Q6_Stack_middle {
    static int count = 0;

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < 10; i++) {
            stack.push(i+1);
        }
        printStack(stack);
        System.out.println();
        delMiddle(stack);
        printStack(stack);
    }

    private static void printStack(Stack<Integer> pStack) {
        if(!pStack.isEmpty()){
            int data = pStack.pop();
            System.out.print(data + " ");
            printStack(pStack);
            pStack.push(data);
        }
    }

    private static void delMiddle(Stack<Integer> pStack) {
        int i = 0;
        delete(pStack, i);
    }

    private static void delete(Stack<Integer> pStack, int pI) {
        int data;
        if (pStack.isEmpty()) {
            count = pI;
        } else {
            data = pStack.pop();
            delete(pStack, pI + 1);
            if (count / 2 != pI) {
                pStack.push(data);
            }
        }
    }
}
