package practice.aug02;

/**
 * Convert array into Zig-Zag fashion
 * Given an array of distinct elements, rearrange the elements of array in zig-zag fashion in O(n) time.
 * The converted array should be in form a < b > c < d > e < f.
 */

public class Q10_Zigzag {

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
                if (pArr[i] > pArr[i + 1]) {
                    swap(pArr, i, i + 1);
                }
            }else{
                if(pArr[i] < pArr[i + 1]){
                    swap(pArr, i, i+1);
                }
            }
            flag = !flag;
        }
    }

    private static void swap(int[] pArr, int pI, int pI1) {
        int temp = pArr[pI];
        pArr[pI] = pArr[pI1];
        pArr[pI1] = temp;
    }
}

