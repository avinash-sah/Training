package practice.mustdo.string;

public class QString_LongestCommonPrefix {

    public static void main(String[] args) {
        String arr[] = {"geeksforgeeks", "geeks",
                "geek", "geezer"};
        int n = arr.length;

        String ans = commonPrefix(arr);

        if (ans.length() > 0)
            System.out.println("The longest common"
                    + " prefix is " + ans);
        else
            System.out.println("There is no common"
                    + " prefix");
    }

    private static String commonPrefix(String[] pArr) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < pArr.length; i++) {
            if (min > pArr[i].length()) {
                min = pArr[i].length();
            }
        }

        String prefix = "";

        int l = 0;
        int h = min;

        while (l <= h) {
            int mid = l + (h - l) / 2;

            if (isCommonPrefix(pArr, pArr[0], l, mid)) {
                prefix += pArr[0].substring(l, mid - l + 1);
                l = mid + 1;
            } else {
                h = mid - 1;
            }
        }
        return prefix;
    }

    private static boolean isCommonPrefix(String[] pArr, String pS, int pL, int pMid) {

        for (int i = 0; i < pArr.length; i++) {
            for (int j = pL; j <= pMid; j++) {
                if (pArr[i].charAt(j) != pS.charAt(j)) {
                    return false;
                }
            }
        }
        return true;
    }
}
