package train.tree;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class AscendingSort {

    public static void main(String[] args) {
        Integer[] a = { 1, 2, 3};
        List<Integer> ints = Arrays.asList(a);
        List<Integer> re = rearrange(ints);

        System.out.println(re);

    }

    static List<Integer> rearrange(List<Integer> elements) {
        elements.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                int count1 = countBits(o1);
                int count2 = countBits(o2);

                if(count1 == count2){
                    return o1.compareTo(o2);
                }else if(count1 < count2){
                    return -1;
                }else{
                    return 1;
                }
            }


        });
        return elements;
    }

    private static int countBits(int i) {
        int count = 0;
        while (i > 0) {
            if ((i & 1) == 1) {
                count++;
            }
            i >>= 1;
        }
        return count;
    }
}
