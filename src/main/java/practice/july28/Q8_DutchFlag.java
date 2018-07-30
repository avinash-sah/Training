package practice.july28;

public class Q8_DutchFlag {
    //sorts 0, 1, 2
    public static void main(String[] args) {
        int arr[] = {0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1};
        sort012(arr);
        for (int i : arr) {
            System.out.print(i);
        }
        System.out.println();
    }

    private static void sort012(int[] pArr) {
        int low = 0;
        int mid = 0;
        int hi = pArr.length - 1;

        while (mid <= hi) {
            switch (pArr[mid]) {
                case 0:
                    swap(pArr, low, mid);
                    mid++;
                    low++;
                    break;
                case 1:
                    mid++;
                    break;
                case 2:
                    swap(pArr, hi, mid);
                    hi--;
                    break;
                default:
                    return;
            }
        }

    }

    private static void swap(int[] pArr, int i, int j) {
        pArr[i] ^= pArr[j];
        pArr[j] ^= pArr[i];
        pArr[i] ^= pArr[j];
    }
}
