package practice.july29;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Q12_CustomSort {
    public static void main(String[] args) {
        Integer[] A1 = {2, 1, 2, 5, 7, 1, 9, 3, 6, 8, 8, 7, 5, 6, 9, 7, 5};
        int[] A2 = {2, 1, 8, 3, 4};

        Arrays.sort(A1, new ExComparator(A2));
        Arrays.stream(A1).forEach(System.out::print);
    }

    static class ExComparator implements Comparator<Integer> {
        Map<Integer, Integer> map = new HashMap<>();

        ExComparator(int[] A2) {
            for (int i = 0; i < A2.length; i++) {
                map.put(A2[i],i);
            }
        }

        int getIndex(Integer i) {
            return map.get(i) != null ? map.get(i) : -1;
        }

        @Override
        public int compare(Integer o1, Integer o2) {
            int index1 = getIndex(o1);
            int index2 = getIndex(o2);
            if(index1 != -1 && index2 != -1){
                return index1 - index2;
            }else if(index1 != -1){
                return -1;
            }else if(index2 != -1){
                return 1;
            }else{
                return o1 - o2;
            }
        }
    }
}
