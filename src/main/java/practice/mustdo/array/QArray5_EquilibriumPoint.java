package practice.mustdo.array;

public class QArray5_EquilibriumPoint {
    public static void main(String[] args) {
        int arr[] = {-7, 1, 5, 2, -4, 3, 0};
        System.out.println(getEquilibriumIndex(arr));
    }

    private static int getEquilibriumIndex(int[] pArr) {

        int sum = 0;
        int lSum = 0;

        for (int i = 0; i < pArr.length; i++) {
            sum+= pArr[i];
        }

        for (int i = 0; i < pArr.length; i++) {

            sum -= pArr[i];

            if(lSum == sum){
                return i;
            }
            lSum += pArr[i];
        }
        return -1;
    }
}
