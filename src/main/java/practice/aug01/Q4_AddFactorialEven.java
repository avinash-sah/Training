package practice.aug01;

import java.util.Arrays;

/**
 * Given an even number (greater than 2 ), print two prime numbers whose sum will be equal to given number.
 * There may be several combinations possible. Print only first such pair.
 */

public class Q4_AddFactorialEven {
    public static void main(String[] args) {
        printPrimePair(10);
        printPrimePair(74);
    }

    private static void printPrimePair(int pN) {
        //1. find findPrimes below pN
        boolean[] primes = findPrimes(pN);
        int x = 0, y = 0;
        //2. Iterate
        for (int i = 0; i < pN; i++) {
            if(primes[i] && primes[pN - i]){
                x = i;
                y = pN - x;
                break;
            }
        }
        System.out.println(x + " "+y);
    }

    private static boolean[] findPrimes(int pN) {
        boolean[] statics = new boolean[pN+1];
        Arrays.fill(statics, true);
        statics[0] = false;
        statics[1] = false;
        for (int i = 2; i *i < pN; i++) {
            for (int j = 2; i * j <= pN; j++) {
                statics[i * j] = false;
            }
        }
        return statics;
    }
}
