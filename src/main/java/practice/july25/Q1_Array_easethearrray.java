package practice.july25;

public class Q1_Array_easethearrray {

    /*

    Input : arr[] = {2, 2, 0, 4, 0, 8}
Output : 4 4 8 0 0 0

Input : arr[] = {0, 2, 2, 2, 0, 6, 6, 0, 0, 8}
Output :  4 2 12 8 0 0 0 0 0 0
    */

    public static final int INVALID = 0;

    public static void main(String[] args) {
        int[] arr = {0, 1, 2, 2, 0};
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] != INVALID && arr[i] == arr[i + 1]) {
                arr[i] *= 2;
                arr[i + 1] = 0;
            }
        }

        for (int i = 0; i < arr.length - 1; i++) {
            boolean isLast = false;
            if (arr[i] == 0) {
                for (int j = i + 1; j < arr.length; j++) {
                    if (arr[j] != 0) {
                        arr[i] = arr[j];
                        arr[j] = 0;
                        break;
                    }
                    if (j == arr.length - 1) {
                        isLast = true;
                    }
                }
            }
            if (isLast) {
                break;
            }
        }

        for (int anArr : arr) {
            System.out.print(anArr + " ");
        }
        System.out.println();


    }
}
