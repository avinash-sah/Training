package practice.mustdo;

public class QArray29_NutBolt {

    public static void main(String[] args) {
        // Nuts and bolts are represented as array of characters
        char nuts[] = {'@', '#', '$', '%', '^', '&'};
        char bolts[] = {'$', '%', '&', '^', '@', '#'};

        // Method based on quick sort which matches nuts and bolts
        matchPairs(nuts, bolts, 0, 5);

        System.out.println("Matched nuts and bolts are : ");
        printArray(nuts);
        printArray(bolts);
    }

    private static void matchPairs(char[] pNuts, char[] pBolts, int pLow, int pHigh) {
        if (pLow < pHigh) {
            int pivot = partition(pNuts, pLow, pHigh, pBolts[pHigh]);
            partition(pBolts, pLow, pHigh, pNuts[pivot]);
            matchPairs(pNuts, pBolts, pLow, pivot - 1);
            matchPairs(pNuts, pBolts, pivot + 1, pHigh);
        }
    }

    private static int partition(char[] pArr, int pLow, int pHigh, char pivot) {
        int i = pLow;
        for (int j = pLow; j < pHigh; j++) {
            if (pArr[j] < pivot) {
                char temp = pArr[j];
                pArr[j] = pArr[i];
                pArr[i] = temp;
                i++;
            } else if (pArr[j] == pivot) {
                char temp = pArr[j];
                pArr[j] = pArr[pHigh];
                pArr[pHigh] = temp;
                j--;
            }
        }

        char temp = pArr[i];
        pArr[i] = pArr[pHigh];
        pArr[pHigh] = temp;
        return i;
    }

    // Method to print the array
    private static void printArray(char[] arr) {
        for (char ch : arr) {
            System.out.print(ch + " ");
        }
        System.out.println();
    }
}
