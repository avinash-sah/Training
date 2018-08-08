package practice.mustdo;

public class QArray7_LeaderInArray {
    public static void main(String[] args) {
        int arr[] = new int[]{16, 17, 4, 3, 5, 2};
        findLeader(arr);
    }

    private static void findLeader(int[] pArr) {
        int n = pArr.length;
        int leader = pArr[n - 1];
        System.out.print(leader + " ");

        for (int i = n - 2; i >= 0; i--) {
            if (leader < pArr[i]) {
                leader = pArr[i];
                System.out.print(pArr[i] + " ");
            }
        }
    }
}
