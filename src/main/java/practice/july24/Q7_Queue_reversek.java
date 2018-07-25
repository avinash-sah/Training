package practice.july24;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Q7_Queue_reversek {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int iter = 0; iter < t; iter++) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            Queue<Integer> queue = new LinkedList<>();
            for (int i = 0; i < n; i++) {
                queue.add(sc.nextInt());
            }
            reverse(queue, k);
            printQ(queue);
        }
        sc.close();

    }

    private static void reverse(Queue<Integer> pArr, int pK) {
        Stack<Integer> integers = new Stack<>();
        for (int i = 0; i < pK; i++) {
            integers.push(pArr.remove());
        }
        Queue<Integer> result = new LinkedList<>();
        while (!pArr.isEmpty()) {
            result.add(pArr.remove());
        }
        while (!integers.empty()) {
            pArr.add(integers.pop());
        }
        while (!result.isEmpty()) {
            pArr.add(result.remove());
        }
    }

    private static void printQ(Queue<Integer> pArr) {
       while (!pArr.isEmpty()){
           System.out.print(pArr.remove() + " ");
       }
        System.out.println();
    }


}
