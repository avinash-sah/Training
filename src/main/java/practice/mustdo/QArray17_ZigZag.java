package practice.mustdo;

public class QArray17_ZigZag {
    public static void main(String[] args) {
        int arr[] = {4, 3, 7, 8, 6, 2, 1};
        zigzagSort(arr);
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    private static void zigzagSort(int[] pArr) {
        boolean flag = true;

        for (int i = 0; i < pArr.length - 1; i++) {
            if (flag) {
                if (pArr[i] < pArr[i + 1]) {
                    int temp = pArr[i + 1];
                    pArr[i + 1] = pArr[i];
                    pArr[i] = temp;
                }
            } else {
                if (pArr[i] > pArr[i + 1]) {
                    int temp = pArr[i + 1];
                    pArr[i + 1] = pArr[i];
                    pArr[i] = temp;
                }
            }
            flag = !flag;
        }
    }
}
