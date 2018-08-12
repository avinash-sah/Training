package practice.mustdo.array;

import java.util.Deque;
import java.util.LinkedList;

public class QArray9_MaxSubArrayK {

    public static void main(String[] args) {
        int arr[] = {12, 1, 78, 90, 57, 89, 56};
        int k = 3;
        printMax(arr, arr.length, k);
    }

    private static void printMax(int[] pArr, int pLength, int pK) {

        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < pK; i++) {
            while (!deque.isEmpty() && pArr[i] >= pArr[deque.peekLast()]) {
                deque.removeLast();
            }
            deque.addLast(i);
        }

        for (int i = pK; i < pLength; i++) {
            System.out.print(pArr[deque.peek()] + " ");

            while (!deque.isEmpty() && deque.peek() <= i - pK){
                deque.removeFirst();
            }

            while (!deque.isEmpty() && pArr[i] >= pArr[deque.peekLast()]){
                deque.removeLast();
            }
            deque.addLast(i);
        }

        System.out.print(pArr[deque.peek()]);
    }
}
