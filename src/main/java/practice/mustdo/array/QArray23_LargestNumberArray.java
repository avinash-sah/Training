package practice.mustdo.array;

import java.util.Arrays;
import java.util.Comparator;

public class QArray23_LargestNumberArray {
    public static void main(String[] args) {
        String arr[] = {
                "54",
                "546",
                "548",
                "60"
        };

        Arrays.sort(arr, (o1, o2) -> {
            String xy = o1+02;
            String yx = o2+o1;
            return yx.compareTo(xy);
        });

        Arrays.stream(arr).forEach(System.out::print);

    }
}
