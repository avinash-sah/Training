package practice.mustdo.hashing;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class QHash_PairSwapping {

    public static void main(String[] args) {
        int A[] = {4, 1, 2, 1, 1, 2};
        int n = A.length;
        int B[] = {3, 6, 3, 3};
        int m = B.length;

        // Call to function
        findSwapValues(A, n, B, m);
    }

    private static void findSwapValues(int[] x, int n, int[] y, int m) {
        int[] a;
        int[] b;

        if (n > m) {
            a = x;
            b = y;
        } else {
            a = y;
            b = x;
        }

        int sumA = Arrays.stream(a).sum();
        int sumB = Arrays.stream(b).sum();

        int diff = (sumA - sumB) / 2;

        Set<Integer> integerSet = new HashSet<>();
        Arrays.stream(a).forEach(integerSet::add);

        boolean flag = false;

        for (int p : b) {
            if (integerSet.contains(p + diff)){
                System.out.println((p + diff) + " "+ p );
                flag = true;
                break;
            }
        }

        if(!flag){
            System.out.println("no such element");
        }


    }


}
