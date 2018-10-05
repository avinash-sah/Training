package practice.mustdo.array;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.stream.Stream;

public class QArray23_LargestNumberArray {
    public static void main(String[] args) {
        String arr[] = {
                "54",
                "546",
                "548",
                "60"
        };

        String[] arr1 = Arrays.copyOf(arr, arr.length);
        Arrays.sort(arr1, Collections.reverseOrder());
        Stream.of(arr1).forEach(System.out::print);
        System.out.println();
        Arrays.sort(arr, (o1, o2) -> {
            String xy = o1+o2;
            String yx = o2+o1;
            return yx.compareTo(xy);
        });

        Arrays.stream(arr).forEach(System.out::print);

    }
}
