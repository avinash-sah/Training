package practice.mustdo;

public class QArray16_ElementLesserGreater {

    public static void main(String[] args) {
        int arr[] = {5, 1, 4, 3, 6, 8, 10, 7, 9};
        System.out.println(getElement(arr));
    }

    private static int getElement(int[] pArr) {
        int n = pArr.length;
        int leftMax[] = new int[n];
        leftMax[0] = Integer.MIN_VALUE;
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], pArr[i-1]);
        }

        int rightMin = Integer.MAX_VALUE;
        for (int i = n-1; i >= 0; i--) {
            if (leftMax[i] < pArr[i] && pArr[i] < rightMin) {
                return i;
            }

            rightMin = Math.min(pArr[i], rightMin);
        }

        return -1;
    }
}
