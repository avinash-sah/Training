package train.array;

public class ShiftArray {

    public int[] rightShift(int ar[], int d, int n) {
        int[] retAr = new int[n];
        for (int i = 0; i < n ; i++) {
            retAr[(i + d) % n] = ar[i];
        }
        return retAr;
    }

    public int[] leftShift(int[] ar, int d, int n){
        int[] outInts = new int[n];
        for (int i = 0; i < n; i++) {
            outInts[i] = ar[(i + d) % n];
        }
        return outInts;
    }

    public void inPlaceShift(int[] ar, int d, int n){
        for (int i = 0; i < d; i++) {
            rotate(ar, n);
        }
    }

    public void inPlaceShiftRef(int[] ar, int d, int n){
        int[] temp = new int[d];
        for (int i = 0; i < d; i++) {
            temp[i] = ar[i];
        }
        for (int i = 0; i < n - d; i++) {
            ar[i] = ar[i + d];
        }
        for (int i = 0; i < d; i++) {
            ar[n - d + i] = temp [i];
        }
    }

    private void rotate(int[] pAr, int pN) {
        int temp = pAr[0];
        for (int i = 0; i < pN - 1; i++) {
            pAr[i] = pAr[i + 1];
        }
        pAr[pN -1] = temp;
    }

    public void juggler(int[] pArray, int d, int n){

    }
}
