package practice.july25;

public class Q10_Array_Subarray_Sum {
    public static void main(String[] args) {
        int arr[] = {1, 4, 20, 3, 10, 5};
        int sum = 33;
        findIndexforSum(arr, sum);
        findIndexforSum_op(arr, sum);
    }

    static void findIndexforSum_op(int[] arr, int sum) {

        int currSum = arr[0];
        int start = 0;
        for (int i = 1; i <= arr.length; i++) {
            while (currSum > sum && start < i - 1) {
                currSum = currSum - arr[start];
                start++;
            }
            if (currSum == sum) {
                System.out.println("Indexes " + start + " " + (i - 1));
                return;
            }
            if (i < arr.length) { //after adding checks for the sum
                currSum += arr[i];
            }

        }
        System.out.println("Not found");

    }

    static void findIndexforSum(int[] arr, int sum) {

        int n = arr.length;
        for (int i = 0; i < n; i++) {
            int curr_sum = arr[i];
            for (int j = i + 1; j <= n; j++) {
                if (curr_sum == sum) {
                    System.out.println("Index " + i + "-" + (j - 1));
                    return;
                }
                if (curr_sum > sum || j == n) {
                    break;
                }
                curr_sum += arr[j];
            }
        }
    }
}
