package practice.july24;

public class Q3_Dyna_LIS {
    public static void main(String[] args) {
        int arr[] = {10, 22, 9, 33, 21, 50, 41, 60};
        int n = arr.length;
        System.out.println("Length of lis is " + lis(arr, n));
    }

    private static int lis(int[] pArr, int pN) {
        int[] lis = new int[pN];
        for (int i = 0; i < pN; i++) {
            lis[i] = 1;
        }

        for (int i = 1; i < pN; i++) {
            for (int j = 0; j < i; j++) {
                if (pArr[j] < pArr[i] && lis[i] < lis[j] + 1) {
                    lis[i] = lis[j] + 1;
                }
            }
        }

        int max = 0;
        for (int i = 0; i < pN; i++) {
            if (max < lis[i]) {
                max = lis[i];
            }
        }
        return max;


    }
}
