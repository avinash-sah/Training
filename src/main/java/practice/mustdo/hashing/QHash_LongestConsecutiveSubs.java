package practice.mustdo.hashing;

import java.util.HashSet;
import java.util.Set;

public class QHash_LongestConsecutiveSubs {

    public static void main(String[] args) {
        int arr[] =  {1, 9, 3, 10, 4, 20, 2};
        System.out.println("Length of the Longest consecutive subsequence is " +
                findLongestConsecSubseq(arr));
    }

    private static int findLongestConsecSubseq(int[] arr) {
        int len = 0;
        Set<Integer> hash = new HashSet<>();

        for (int a:arr) {
            hash.add(a);
        }

        for (int i = 0; i < arr.length; i++) {
            if(!hash.contains(arr[i] -1)){
                int j = arr[i];
                while (hash.contains(j)){
                    j++;
                }
                if(len < j - arr[i]){
                    len = j - arr[i];
                }
            }
        }
        return len;
    }
}
