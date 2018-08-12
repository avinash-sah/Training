package practice.mustdo.array;

public class QArray12_TrappingRain {
    public static void main(String[] args) {
        int arr[] = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int trap = findTrapWater(arr);
        System.out.println(trap);

    }

    private static int findTrapWater(int[] pArr) {
        int lMax = 0;
        int rMax = 0;
        int l = 0;
        int r = pArr.length - 1;

        int trap = 0;

        while (l < r) {
            if (pArr[l] < pArr[r]) {
                if (pArr[l] > lMax) {
                    lMax = pArr[l];
                } else {
                    trap += (lMax - pArr[l]);
                    l++;
                }
            } else {
                if (pArr[r] > rMax) {
                    rMax = pArr[r];
                } else {
                    trap += (rMax - pArr[r]);
                    r--;
                }

            }
        }
        return trap;
    }
}
