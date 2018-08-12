package practice.mustdo.array;

public class QArray10_ReverseGroupArray {

    public static void main(String[] args) {

        int arr[] = {1, 2, 3, 4, 5, 6, 7, 8};
        int k = 3;
        int n = arr.length;
        reverse(arr, n, k);

        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    private static void reverse(int[] pArr, int pN, int pK) {
        for (int i = 0; i < pN; i = i + pK) {
            int left = i;
            int right = Math.min(i + pK - 1, pN - 1);
            int temp;

            while (left < right) {
                temp = pArr[left];
                pArr[left] = pArr[right];
                pArr[right] = temp;

                left++;
                right--;
            }
        }
    }
}
