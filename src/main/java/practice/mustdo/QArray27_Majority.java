package practice.mustdo;

public class QArray27_Majority {

    public static void main(String[] args) {
        int a[] = new int[]{2, 2, 2, 2, 5, 5, 2, 3, 3};

        findMajority(a);
    }

    private static void findMajority(int[] pA) {
        int cand = findCandidate(pA);

        if (isMajority(pA, cand)) {
            System.out.println(" Majority " + cand);
        } else {
            System.out.println("No Majority");
        }
    }

    private static boolean isMajority(int[] pA, int pCand) {
        int count = 0;
        for (int aPA : pA) {
            if (aPA == pCand) {
                count++;
                if (count > pA.length / 2) {
                    return true;
                }
            }
        }
        return false;
    }

    private static int findCandidate(int[] pA) {
        int maxI = 0;
        int count = 1;
        for (int i = 1; i < pA.length; i++) {
            if (pA[i] == pA[maxI]) {
                count++;
                if (count > pA.length / 2) {
                    return pA[maxI];
                }
            } else {
                count--;
            }
            if (count == 0) {
                maxI = i;
                count = 1;
            }
        }
        return pA[maxI];
    }


}
