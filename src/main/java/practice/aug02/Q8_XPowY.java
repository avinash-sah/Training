package practice.aug02;

public class Q8_XPowY {
    public static void main(String[] args) {
        System.out.println(isPow(48));
        System.out.println(isPow(49));
    }

    static boolean isPow(int n) {
        for (int x = 2; x * x <= n; x++) {
            int p = x;
            while (p <= n) {
                p = p * x;
                if (p == n) {
                    return true;
                }
            }
        }
        return false;
    }
}
