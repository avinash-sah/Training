package practice.mustdo;

public class QArray4_sort012 {

    public static void main(String[] args) {
        int arr[] = {0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1};
        sort012(arr);
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    private static void sort012(int[] pArr) {
        int n = pArr.length;
        int low = 0;
        int mid = 0;
        int high = n - 1;
        while(mid <= high){
            switch (pArr[mid]) {
                case 0:
                    swap(pArr, low, mid);
                    low++;
                    mid++;
                    break;
                case 1:
                    mid++;
                    break;
                case 2:
                    swap(pArr, mid, high);
                    high--;
                    break;
            }
        }

    }

    private static void swap(int[] pArr, int pX, int pY) {
        int temp = pArr[pX];
        pArr[pX] = pArr[pY];
        pArr[pY] = temp;
    }
}
