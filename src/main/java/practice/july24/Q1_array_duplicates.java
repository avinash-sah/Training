package practice.july24;

public class Q1_array_duplicates {

    public static void main(String[] args) {
        int[][] input = {
                {5, 2, 3, 6, 4, 4, 6, 6},
                {10, 14, 10, 12, 12, 13, 15}
        };
        for (int[] arr : input)
            find(arr);
    }


    private static void find(int[] input) {
        boolean status = true;
        //sort
        sort(input);
        //check for continuity
        for (int i = 0; i < input.length - 1; i++) {
            int j = input[i + 1] - input[i];
            if (j != 0 && j != 1) {
                status = false;
                break;
            }
        }
        System.out.println(status ? "Yes" : "No");
    }

    private static void sort(int[] pInput) {
        int n = pInput.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (pInput[i] > pInput[j]) {
                    pInput[i] ^= pInput[j];
                    pInput[j] ^= pInput[i];
                    pInput[i] ^= pInput[j];
                }
            }
        }
    }


}
