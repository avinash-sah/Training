package practice.mustdo;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class QArray20_RelativeSorting {

    public static void main(String[] args) {
        Integer A1[] = {2, 1, 2, 5, 7, 1, 9, 3, 6, 8, 8};
        int A2[] = {2, 1, 8, 3};
        int m = A1.length;
        int n = A2.length;
        System.out.println("Sorted array is ");
        Arrays.sort(A1, new RelativeComparator(A2));
        for (int i : A1) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    static class RelativeComparator implements Comparator<Integer> {
        Map<Integer, Integer> map = new HashMap<>();

        public RelativeComparator(int[] pA2) {
            for (int i = 0; i < pA2.length; i++) {
                map.put(pA2[i], i);
            }
        }

        @Override
        public int compare(Integer o1, Integer o2) {
            int indx1 = getIndex(o1);
            int indx2 = getIndex(o2);
            if (indx1 != -1 && indx2 != -1) {
                return indx1 - indx2;
            } else if (indx1 != -1) {
                return -1;
            } else if (indx2 != -1) {
                return 1;
            } else {
                return o1 - o2;
            }
        }

        private int getIndex(Integer o1) {
            return map.get(o1) != null ? map.get(o1) : -1;
        }
    }

}
