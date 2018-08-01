package practice.july29;

public class Q9_FittingShelves {

    public static void main(String[] args) {
        int wall = 24;
        int m = 3;
        int n = 5;
        minimumSpace(wall, m, n);
        minimumSpace(29, 3, 9);
    }

    private static void minimumSpace(int pWall, int pM, int pN) {
        int num_m = 0;
        int num_n = 0;
        int num_e = pWall;

        for (int i = 1; i <= pWall / pN; i++) {
            int r_wall = pWall - i * pN;
            if (num_e >= r_wall % pM && num_n < i) {
                num_e = r_wall % pM;
                num_n = i;
                num_m = r_wall / pM;
            }
        }

        System.out.println(num_m + " " + num_n + " " + num_e);

    }
}
