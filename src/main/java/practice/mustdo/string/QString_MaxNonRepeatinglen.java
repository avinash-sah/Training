package practice.mustdo.string;

public class QString_MaxNonRepeatinglen {

    public static final int MAX = 256;

    public static void main(String[] args) {
        String str = "ABDEFGABEF";
        System.out.println("The input string is " + str);
        int len = longestUniqueSubstr(str);
        System.out.println("The length of "
                + "the longest non repeating character is " + len);
    }

    private static int longestUniqueSubstr(String pStr) {
        int max_len = 1;
        int curr_len = 1;
        int[] visited = new int[MAX];
        for (int i = 0; i < visited.length; i++) {
            visited[i] = -1;
        }

        int prev_index;

        visited[pStr.charAt(0)] = 0;

        for (int i = 1; i < pStr.length(); i++) {

            prev_index = visited[pStr.charAt(i)];

            if (prev_index == -1 || i - curr_len > prev_index) {
                curr_len++;
            } else {
                if (curr_len > max_len) {
                    max_len = curr_len;
                }
                curr_len = i - prev_index;
            }
            visited[pStr.charAt(i)] = i;

        }

        return max_len;
    }
}
