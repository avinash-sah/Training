package practice.aug02;

import java.util.LinkedList;
import java.util.Queue;

public class Q2_NStepsChild {
    public static void main(String[] args) {
        int[] steps = {1, 2, 3};
        int N = 10;

        int min_step = getMinSteps(steps, N);
        System.out.println(min_step);
    }

    private static int getMinSteps(int[] pSteps, int pN) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(pN);
        int count;
        int level = -1;
        while (!queue.isEmpty()) {
            count = queue.size();
            level++;
            while (count > 0) {
                int s = queue.poll();
                if (s == 0) {
                    return level;
                }
                for (int i = 0; i < pSteps.length; i++) {
                    if (s - pSteps[i] >= 0) {
                        queue.add(s - pSteps[i]);
                    }
                }
                count--;
            }


        }
        return level;
    }
}
