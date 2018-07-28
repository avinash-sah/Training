package practice.july28;

public class Q6_BinarySearch {

    public static void main(String[] args) {
        int arr[] = {2, 3, 4, 10, 40};
        int x = 3;
        int n = arr.length;
        boolean res = binarySearch_r(arr, x, 0, n - 1);
        System.out.println(binarySearch_i(arr, x));
        System.out.println(res);
    }

    static boolean binarySearch_r(int[] pInts, int x, int pLow, int pHigh) {
        if (pHigh >= pLow) {
            int mid = pLow + (pHigh - pLow) / 2;
            if (pInts[mid] == x) {
                return true;
            } else if (pInts[mid] < x) {
                return binarySearch_r(pInts, x, mid + 1, pHigh);
            } else {
                return binarySearch_r(pInts, x, pLow, mid - 1);
            }
        }
        return false;
    }

    static boolean binarySearch_i(int[] pInts, int x) {

        int low = 0;
        int high = pInts.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (pInts[mid] == x) {
                return true;
            } else if (pInts[mid] > x) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return false;
    }
}
