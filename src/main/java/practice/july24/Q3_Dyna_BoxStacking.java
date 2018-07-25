package practice.july24;

import java.util.Arrays;

public class Q3_Dyna_BoxStacking {

    public static void main(String[] args) {
        /*Box[] arr = new Box[4];
        arr[0] = new Box(4, 6, 7);
        arr[1] = new Box(1, 2, 3);
        arr[2] = new Box(4, 5, 6);
        arr[3] = new Box(10, 12, 32);*/

        Box[] arr = {
                new Box(1, 2, 4),
                new Box(3, 2, 5)
        };


        System.out.println("The maximum possible "+
                "height of stack is " +
                maxStackHeight(arr,arr.length));
    }

    private static int maxStackHeight(Box[] pArr, int pI) {
        int n = pI * 3;
        Box[] boxes = new Box[n];

        for (int i = 0; i < pI; i++) {
            Box box = pArr[i];
            boxes[3*i + 0] = new Box(Math.max(box.l, box.w), Math.min(box.l, box.w), box.h);
            boxes[3*i + 1] = new Box(Math.max(box.l, box.h), Math.min(box.l, box.h), box.w);
            boxes[3*i + 2] = new Box(Math.max(box.w, box.h), Math.min(box.w, box.h), box.l);
        }

        Arrays.sort(boxes);

        int[] length = new int[n];
        int[] stack = new int[n];

        for (int i = 0; i < n; i++) {
            length[i] = boxes[i].h;
            stack[i] = 0;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if(boxes[i].l < boxes[j].l &&
                        boxes[i].w < boxes[j].w){
                    if(length[i] < length[j] + boxes[i].h){
                        length[i] = length[j] + boxes[i].h;
                        stack[i] = j;
                    }
                }
            }

        }

        int max  = 0;
        for (int i = 0; i < n; i++) {
            System.out.print(i+ " "+ stack[i] + " ");
            System.out.print(length[i] + " ");
            System.out.println(boxes[i] + " ");
            if(max < length[i]){
                max = length[i];
            }
        }
        System.out.println();

        return max;
    }

    static class Box implements Comparable<Box> {
        int l, w, h;
        int area;

        public Box(int pL, int pW, int pH) {
            l = pL;
            w = pW;
            h = pH;
            area = l* w;
        }

        @Override
        public String toString() {
            return ""+l+ ":"+ w + ":"+h;
        }

        @Override
        public int compareTo(Box o) {
            return o.area - area;
        }
    }
}
