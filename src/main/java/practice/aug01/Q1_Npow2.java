package practice.aug01;

public class Q1_Npow2 {
    public static void main(String[] args) {
        maxPower2(10);
        maxPower2(19);
        maxPower2(2047);
    }

    private static void maxPower2(int N) {
        int res = 1;
        while (N > 1) {
            res *= 2;
            N = N / 2;
        }
        System.out.println(res);

    }

}
