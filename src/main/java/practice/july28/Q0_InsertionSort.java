package practice.july28;

public class Q0_InsertionSort {

    public static void main(String[] args) {
        int arr[] = {12, 11, 13, 5, 6};
        insertionSort(arr);
        for (int i: arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int j = i - 1;
            int key = arr[i];
            while (j >= 0 && key < arr[j]) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }
}
