package practice.mustdo;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class QArray22_FrequencySort {

    public static void main(String[] args) {
        Integer a[] = { 2, 5, 2, 6, -1, 9999999, 5, 8, 8, 8 };
        Arrays.sort(a, new FreqSort(a));
        Arrays.stream(a).forEach(pInteger -> System.out.print(pInteger + " "));
    }

    static class FreqSort implements Comparator<Integer>{

        Map<Integer, Integer> map = new HashMap<>();
        Map<Integer, Integer> orderMap = new HashMap<>();

        FreqSort(Integer[] arr){
            for (int i = 0; i < arr.length; i++) {
                map.merge(arr[i], 1, (a, b) -> a + b);
                orderMap.putIfAbsent(arr[i], i);
            }
        }

        @Override
        public int compare(Integer o1, Integer o2) {
            if(o1.equals(o2)){
                return 0;
            }else{
                if(map.get(o1).equals(map.get(o2))){
                    return orderMap.get(o1) - orderMap.get(o2);
                }else {
                    return Integer.compare(map.get(o2), map.get(o1));
                }
            }
        }
    }
}
