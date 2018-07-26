package practice.july25;

public class Q2_Dyna_01Knapsack {
    public static void main(String[] args) {
        int val[] = new int[]{60, 100, 120};
        int wt[] = new int[]{10, 20, 30};
        int W = 50;
        int n = val.length;
        System.out.println(knapSack(W, wt, val, n));
    }

    private static int knapSack(int pW, int[] pWt, int[] pVal, int pN) {
        int[][] knap = new int[pN+1][pW+1];

        for (int i = 0; i < pN+1; i++) {
            for (int j = 0; j < pW+1; j++) {
                if(i == 0 || j == 0){
                    knap[i][j] = 0;
                }else if(pWt[i - 1] <= j){
                    knap[i][j] = Math.max(pVal[i - 1] + knap[i-1][j - pWt[i-1]], knap[i-1][j]);
                }else{
                    knap[i][j] = knap[i-1][j];
                }
            }

        }

        return knap[pN][pW];
    }
}
