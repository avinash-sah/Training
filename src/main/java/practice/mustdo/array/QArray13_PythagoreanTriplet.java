package practice.mustdo.array;

import java.util.Arrays;

public class QArray13_PythagoreanTriplet {
    public static void main(String[] args) {
        int arr[] = {3, 1, 4, 6, 5};
        int arr_size = arr.length;
        if (isTriplet(arr, arr_size))
            System.out.println("Yes");
        else
            System.out.println("No");
    }

    private static boolean isTriplet(int[] pArr, int pArr_size) {
        int arr[] = new int[pArr_size];
        for (int i = 0; i < pArr_size; i++) {
            arr[i] = pArr[i] * pArr[i];
        }
        Arrays.sort(arr);
        Arrays.sort(pArr);

        for (int i = pArr_size - 1; i >= 2; i--) {
            int l = 0;
            int r = i - 1;
            while (l < r) {
                if (arr[l] + arr[r] == arr[i]) {
                    System.out.println(pArr[l] + " " + pArr[r] + " " + pArr[i]);
                    System.out.println(arr[l] + " " + arr[r] + " " + arr[i]);
                    return true;
                }

                if (arr[l] + arr[r] > arr[i]) {
                    r--;
                } else {
                    l++;
                }
            }
        }
        return false;
    }
}
