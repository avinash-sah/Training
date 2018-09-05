package practice.mustdo.recursion;

public class QRec_Josephus {
    public static void main(String[] args) {
        int n = 14;
        int k = 2;
        System.out.println("The chosen place is " + josephus(n, k));
    }

    private static int josephus(int n, int k) {
        if (n == 1) {
            return 1;
        }
        return (josephus(n - 1, k) + k - 1) % n + 1;
    }

}
