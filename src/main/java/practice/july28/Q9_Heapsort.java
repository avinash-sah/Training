package practice.july28;

public class Q9_Heapsort {

    public static void main(String[] args) {
        int arr[] = {12, 11, 13, 5, 6, 7};

        heap_sort(arr);
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    private static void heap_sort(int[] pArr) {
        int n = pArr.length;
        //n/2 -1 is the last possible root in heap
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(pArr, n, i);
        }

        //now sorting
        for (int i = n - 1; i > 0; i--) {
            swap(pArr, i, 0);
            heapify(pArr, i, 0);
        }

    }

    private static void heapify(int[] pArr, int pN, int pI) {

        int max = pI;
        int l = 2 * pI + 1;
        int r = 2 * pI + 2;

        if (l < pN && pArr[l] > pArr[max]) {
            max = l;
        }
        if (r < pN && pArr[r] > pArr[max]) {
            max = r;
        }

        if (max != pI) {
            swap(pArr, pI, max);
            heapify(pArr, pN, max);
        }
    }

    private static void swap(int[] pArr, int pI, int pJ) {
       /* if (pArr[pI] == pArr[pJ]) {
            return;
        }*/

        pArr[pI] = pArr[pI] + pArr[pJ];
        pArr[pJ] = pArr[pI] - pArr[pJ];
        pArr[pI] = pArr[pI] - pArr[pJ];
    }


}
