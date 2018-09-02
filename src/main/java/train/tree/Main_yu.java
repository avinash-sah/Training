package train.tree;

public class Main_yu {

    public static void main(String[] args) {
        String s = "gfg";
        String[] st = {
                "xy", "pp", "hefg"
        };

        for (String str: st) {
            System.out.println(nextpermutation(str));
        }
        String val = nextpermutation(s);
        System.out.println(val);
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
            result = "No Answer";
        } else {
            int index = search(s, i + 1, len - 1, s[i]);
            swap(s, i, index);
            reverse(s, i + 1, len - 1);
            result = new String(s);
        }
        return result;
    }

    private static void reverse(char[] s, int l, int r) {
        while (l < r){
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


