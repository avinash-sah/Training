package practice.july28;

public class Q8_3WayQuickSort_Dutch {

    public static void main(String[] args) {
        int a[] = {4, 9, 4, 4, 1, 9, 4, 4, 9, 4, 4, 1, 4};
        //int a[] = {4, 39, 54, 14, 31, 89, 44, 34, 59, 64, 64, 11, 41};
        //int a[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        //int a[] = {91, 82, 73, 64, 55, 46, 37, 28, 19, 10};
        //int a[] = {4, 9, 4, 4, 9, 1, 1, 1};
        int size = a.length;

        printArr(a);
        quicksort(a, 0, size - 1);
        printArr(a);
    }

    private static void quicksort(int[] pA, int pLow, int pHigh) {
        if (pLow >= pHigh) {
            return;
        }
        Flag flag = new Flag();
        partition(pA, pLow, pHigh, flag);
        System.out.println("low i j high "+ pLow + " "+ flag.i + " "+ flag.j+ " "+pHigh);
        for (int i = pLow; i <= flag.i; i++) {
            System.out.print(pA[i]);
        }
        System.out.println();
        for (int i = flag.j; i <= pHigh; i++) {
            System.out.print(pA[i]);
        }
        System.out.println();
        quicksort(pA, pLow, flag.i);
        quicksort(pA, flag.j, pHigh);
    }

    private static void partition(int[] pA, int pLow, int pHigh, Flag pFlag) {
        if (pHigh - pLow <= 1) {
            if (pA[pHigh] < pA[pLow]) {
                swap(pA, pHigh, pLow);
            }
            pFlag.i = pLow;
            pFlag.j = pHigh;
            return;
        }

        int mid = pLow;
        int pivot = pA[pHigh];
        while (mid <= pHigh) {
            if (pA[mid] < pivot) {
                swap(pA, mid, pLow);
                pLow++;
                mid++;
            } else if (pA[mid] > pivot) {
                swap(pA, mid, pHigh);
                pHigh--;
            } else {
                mid++;
            }
        }

        pFlag.i = pLow - 1;
        pFlag.j = mid;
    }

    private static void printArr(int[] pA) {
        for (int i : pA) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    private static void swap(int[] pArr, int i, int j) {
        if (i == j) {
            return;
        }
        pArr[i] ^= pArr[j];
        pArr[j] ^= pArr[i];
        pArr[i] ^= pArr[j];
    }

    static class Flag {
        int i;
        int j;
    }


}
