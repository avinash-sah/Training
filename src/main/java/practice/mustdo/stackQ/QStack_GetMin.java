package practice.mustdo.stackQ;

import java.util.Stack;

public class QStack_GetMin {
    public static void main(String[] args) {
        MinStack s = new MinStack();
        s.push(3);
        s.push(5);
        s.getMin();
        s.push(2);
        s.push(1);
        s.getMin();
        s.pop();
        s.getMin();
        s.pop();
    }

    static class MinStack {
        Stack<Integer> mStack = new Stack<>();
        int min;

        int getMin() {
            System.out.println("Get min " + min);
            return min;
        }

        void push(int x) {
            System.out.println("pushed " + x);
            if(mStack.isEmpty()){
                min = x;
                mStack.push(x);
                return;
            }
            if (x < min) {
                mStack.push(2 * x - min);
                min = x;
            } else {
                mStack.push(x);
            }
        }

        int pop() {
            int y = mStack.peek();
            if (y < min) {
                y = min;
                min = 2 * min - mStack.pop();
            } else {
                y = mStack.pop();
            }
            System.out.println("popped " + y);
            return y;
        }
    }
}
