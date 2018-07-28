package practice.july28;

public class Q7_QuickSort {

    public static void main(String[] args) {
        int arr[] = {10, 7, 8, 9, 1, 5};
        sort(arr);
        for (int a: arr) {
            System.out.print(a + " ");
        }
        System.out.println();
    }

    public static void sort(int[] arr) {
        int n = arr.length;
        sortUtil(arr, 0, n - 1);
    }

    private static void sortUtil(int[] pArr, int pLow, int pHigh) {
        if (pLow < pHigh) {
            int k = partition(pArr, pLow, pHigh);
            sortUtil(pArr, pLow, k - 1);
            sortUtil(pArr, k + 1, pHigh);
        }
    }

    private static int partition(int[] pArr, int pLow, int pHigh) {

        int pivot = pArr[pHigh];
        int i = pLow - 1;
        for (int j = pLow; j <= pHigh - 1; j++) {
            if (pArr[j] < pivot) {
                i++;
                swap(pArr, j, i);
            }
        }
        swap(pArr, i + 1, pHigh);
        return i + 1;
    }

    private static void swap(int[] pArr, int pJ, int pI) {
        pArr[pI] = pArr[pI] ^ pArr[pJ];
        pArr[pJ] = pArr[pI] ^ pArr[pJ];
        pArr[pI] = pArr[pI] ^ pArr[pJ];

    }
}
