package practice.aug01;

/**
 *  Given an array of positive integers. 
 *  All numbers occur even number of times except one number which occurs odd number of times.
 *  Find the number in O(n) time & constant space.
 */
public class Q5_DistinctNo {
    public static void main(String[] args) {
        int[] numbers ={1, 2, 3, 2, 3, 1, 3};
        
        int x = findDistinct(numbers);
        System.out.println(x);
    }

    private static int findDistinct(int[] pNumbers) {
        int res = 0;
        for (int i = 0; i < pNumbers.length; i++) {
            res ^= pNumbers[i];

        }
        return res;
    }
}
