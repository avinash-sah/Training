package practice.mustdo.string;

public class QString4_LongestPalindrome {

    public static void main(String[] args) {
        String str = "forgeeksskeegfor";
        System.out.println("Length is: " +
                longestPalSubstr(str));
    }

    private static int longestPalSubstr(String pStr) {

        int n = pStr.length();
        int maxLen = 0;
        int start = 0;
        boolean table[][] = new boolean[n][n];

        maxLen = 1;
        for (int i = 0; i < n; i++) {
            table[i][i] = true;
        }

        for (int i = 0; i < n -1; i++) {
            if(pStr.charAt(i) == pStr.charAt(i + 1)){
                table[i][i+1] = true;
                maxLen = 2;
                start = i;
            }
        }

        for (int k = 3; k < n; k++) {
            for (int i = 0; i < n - k + 1; i++) {
                int j = i + k -1;

                if(table[i+1][j-1] && pStr.charAt(i) == pStr.charAt(j)){
                    table[i][j] = true;
                    if(maxLen < k){
                        maxLen = k;
                        start = i;
                    }

                }
            }
        }
        System.out.println(pStr.substring(start, start + maxLen));
        return maxLen;
    }
}
