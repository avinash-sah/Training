package practice.mustdo.string;

public class QString_MinInsertionPalindrome {
    public static void main(String[] args) {
        String str = "geeks";
        System.out.println(findMinInsertionsDP(str));
        System.out.println(findMinInsertionsDP_2(str));
        System.out.println(findMinInsertions(str.toCharArray(), 0, str.length() - 1));
    }

    private static int findMinInsertions(char[] str, int l, int h) {
        if (l > h) {
            return Integer.MAX_VALUE;
        }
        if (l == h) {
            return 0;
        }
        if (l == h - 1) {
            return str[l] == str[h] ? 1 : 0;
        }

        return str[l] == str[h]
                ? findMinInsertions(str, l + 1, h - 1)
                : 1 + Math.min(
                findMinInsertions(str, l + 1, h),
                findMinInsertions(str, l, h - 1)
        );
    }

    private static int findMinInsertionsDP(String str) {
        char[] chars = str.toCharArray();
        int n = str.length();
        int[][] map = new int[n][n];

        for (int gap = 1; gap < n; gap++) {
            for (int l = 0, h = gap; h < n; l++, h++) {
                map[l][h] = (chars[l] == chars[h])
                        ? map[l + 1][h - 1]
                        : Math.min(map[l + 1][h], map[l][h - 1]) + 1;


            }
        }

        return map[0][n - 1];
    }

    private static int findMinInsertionsDP_2(String str) {
        String rev = new StringBuilder(str).reverse().toString();
        int n = str.length();
        int lcs = lcs(str, rev, n, n);
        System.out.println(n + " " +lcs );
        return n - lcs;
    }

    private static int lcs(String str, String rev, int n, int m) {
        int[][] table = new int[n + 1][m + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                if (i == 0 || j == 0) {
                    table[i][j] = 0;
                } else if (str.charAt(i-1) == rev.charAt(j-1)) {
                    table[i][j] = table[i - 1][j - 1] + 1;
                } else {
                    table[i][j] = Math.max(table[i - 1][j], table[i][j - 1]);
                }
            }
        }
        return table[n][m];
    }
}
