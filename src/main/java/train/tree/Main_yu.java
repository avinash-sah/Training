package train.tree;

public class Main_yu {

    public static void main(String[] args) {
        String s = "gfg";
        String[] st = {
                "xy", "pp", "baca", "abc"
        };

        for (String str : st) {
            System.out.println(rearrangeWord(str));
        }
        String val = rearrangeWord(s);
        System.out.println(val);
    }

    public static String rearrangeWord(String word) {

        int len = word.length();
        int i = len - 2;
        char[] chars = word.toCharArray();
        while (i >= 0 && chars[i] >= chars[i + 1]) {
            i--;
        }
        if (i < 0) {
            return "no answer";
        }

        int index = search(chars, i + 1, len - 1, word.charAt(i));
       for (int j = len -1; j > i ; j--) {
            if(chars[j] < chars[i]){
                index = j;
                break;
            }
        }

        swap(chars, index, i);
        reverse(chars, i + 1, len - 1);
        return new String(chars);
    }

    private static String nextpermutation(String word) {
        String result = null;
        int len = word.length();
        int i = len - 2;
        char[] s = word.toCharArray();

        while (i >= 0 && s[i] >= s[i + 1]) {
            --i;
        }

        if (i < 0) {
            result = "no answer";
        } else {
            int index = search(s, i + 1, len - 1, s[i]);
            swap(s, i, index);
            reverse(s, i + 1, len - 1);
            result = new String(s);
        }
        return result;
    }

    private static void reverse(char[] s, int l, int r) {
        while (l < r) {
            swap(s, l++, r--);
        }
    }

    private static void swap(char[] s, int l, int r) {
        if (s[l] == s[r]) {
            return;
        }
        char temp = s[l];
        s[l] = s[r];
        s[r] = temp;
    }

    private static int search(char[] s, int l, int r, char key) {
        int index = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (s[mid] <= key) {
                r = mid - 1;
            } else {
                l = mid + 1;
                if (index == -1 || s[index] <= s[mid]) {
                    index = mid;
                }
            }
        }
        return index;
    }


}


