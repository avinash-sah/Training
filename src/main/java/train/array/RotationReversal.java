package train.array;

import train.main.ArrayMain;

public class RotationReversal {

    public void rotate(int[] pInts, int count) {
        int n = pInts.length;
        reverse(pInts, 0, count - 1);
        reverse(pInts, count, n - 1);
        reverse(pInts, 0, n - 1);
    }

    private void reverse(int[] pInts, int start, int end) {
        int n = (end - start) / 2;
        for (int i = 0; i <= n; i++) {
            int temp = pInts[start + i];
            pInts[start + i] = pInts[end - i];
            pInts[end - i] = temp;
        }
    }
}
