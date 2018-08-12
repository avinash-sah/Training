package practice.mustdo.array;

public class QArray6_MaxLIS {
    public static void main(String[] args) {
        int arr[] = new int[]{1, 101, 2, 3, 100, 4, 5};
        maxLis(arr);
    }

    private static void maxLis(int[] pArr) {
        int lis[] = new int[pArr.length];
        for (int i = 0; i < pArr.length; i++) {
            lis[i] = pArr[i];
        }

        for (int i = 1; i < pArr.length; i++) {
            for (int j = 0; j < i; j++) {
                if (pArr[i] > pArr[j] && lis[i] < lis[j] + pArr[i]) {
                    lis[i] = lis[j] + pArr[i];
                }
            }
        }

        int max = 0;
        for (int i = 0; i < lis.length; i++) {
            if (max < lis[i]) {
                max = lis[i];
            }
        }

        System.out.println(max);
    }
}
