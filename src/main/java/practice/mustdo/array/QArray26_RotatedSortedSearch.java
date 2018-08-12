package practice.mustdo.array;

public class QArray26_RotatedSortedSearch {

    public static void main(String[] args) {
        int arr[] = {4, 5, 6, 7, 8, 9, 1, 2, 3};
        int n = arr.length;
        int key = 2;
        int i = search(arr, 0, n - 1, key);
        if (i != -1)
            System.out.println("Index: " + i);
        else
            System.out.println("Key not found");
    }

    private static int search(int[] pArr, int pLow, int pHigh, int pKey) {
        if (pLow > pHigh) {
            return -1;
        }

        int mid = pLow + (pHigh - pLow) / 2;
        if (pArr[mid] == pKey) {
            return mid;
        }

        if (pArr[pLow] <= pArr[mid]) {
            //means first half is sorted
            if (pKey >= pArr[pLow] && pKey <= pArr[mid]) {
                return search(pArr, pLow, mid - 1, pKey);
            } else {
                return search(pArr, mid + 1, pHigh, pKey);
            }
        } else if (pKey >= pArr[mid] && pKey <= pArr[pHigh]) {
            return search(pArr, mid + 1, pHigh, pKey);
        } else {
            return search(pArr, pLow, mid - 1, pKey);
        }
    }
}
