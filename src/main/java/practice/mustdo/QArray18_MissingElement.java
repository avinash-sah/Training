package practice.mustdo;


public class QArray18_MissingElement {
    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 4, 4, 5, 5, 6, 6};
        search(arr, 0, arr.length - 1);
    }

    private static void search(int[] pArr, int pLow, int pHigh) {

        if (pLow > pHigh) {
            return;
        }

        if (pLow == pHigh) {
            System.out.println(pArr[pLow]);
            return;
        }

        int mid = pLow + (pHigh - pLow) / 2;

        if (mid % 2 == 0) {
            if (pArr[mid] == pArr[mid + 1]) {
                search(pArr, mid + 2, pHigh);
            } else {
                search(pArr, pLow, mid);
            }
        } else {

            if (pArr[mid] == pArr[mid - 1]) {
                search(pArr, mid + 1, pHigh);
            } else {
                search(pArr, 0, mid - 1);
            }

        }

    }
}
