package practice.aug02;

public class Q9_BinaryFlip {

    public static void main(String[] args) {

        System.out.println(countFlip(10, 20));
        System.out.println(countFlip(7, 10));
    }

    private static int countFlip(int pX, int pY) {
        int count = 0;
        int z = pX ^ pY;
        while (z != 0) {
            count += z & 1;
            z >>= 1;
        }
        return count;
    }
}
