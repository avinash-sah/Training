package practice.july28;

public class Q4_RodCutting {

    public static void main(String[] args) {
        int arr[] = new int[]{1, 5, 8, 9, 10, 17, 17, 20};
        int size = arr.length;
        System.out.println("Maximum Obtainable Value is " +
                cutRod(arr, size));
    }

    private static int cutRod(int[] pArr, int pSize) {
        int val[] = new int[pSize + 1];
        val[0] = 0;

        for (int i = 1; i <= pSize; i++) {
            int max = -1;
            for (int j = 0; j < i; j++) {
                max = Math.max(max, pArr[j] + val[i - j - 1]);
            }
            val[i] = max;
        }
        return val[pSize];
    }


}
