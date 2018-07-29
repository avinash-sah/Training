package practice.july28;

public class Q2_Prims {
    private int V;

    public static void main(String[] args) {
        Q2_Prims t = new Q2_Prims();
        int graph[][] = new int[][]{
                {0, 2, 0, 6, 0},
                {2, 0, 3, 8, 5},
                {0, 3, 0, 0, 7},
                {6, 8, 0, 0, 9},
                {0, 5, 7, 9, 0},
        };
        t.updateV(5);

        // Print the solution
        t.primMST(graph);
    }

    private void updateV(int pI) {
        V = pI;
    }

    private void primMST(int[][] pGraph) {
        boolean mstSet[] = new boolean[V];
        int[] key = new int[V];
        int[] parent = new int[V];

        for (int i = 0; i < V; i++) {
            key[i] = Integer.MAX_VALUE;
            mstSet[i] = false;
        }
        parent[0] = -1;
        key[0] = 0;

        for (int i = 0; i < V - 1; i++) {
            int u = minSet(key, mstSet);
            mstSet[u] = true;

            for (int v = 0; v < V; v++) {
                if (!mstSet[v] && pGraph[u][v] != 0 && key[v] > pGraph[u][v]) {
                    key[v] = pGraph[u][v];
                    parent[v] = u;
                }
            }
        }

        printMST(parent, V, pGraph);

    }

    private int minSet(int[] pKey, boolean[] pMstSet) {
        int min = Integer.MAX_VALUE;
        int index = -1;
        for (int i = 0; i < V; i++) {
            if (!pMstSet[i] && pKey[i] < min) {
                index = i;
                min = pKey[i];
            }
        }
        return index;
    }

    void printMST(int parent[], int n, int graph[][]) {
        System.out.println("Edge   Weight");
        for (int i = 1; i < V; i++) {
            System.out.println(parent[i] + " - " + i + "    " +
                    graph[i][parent[i]]);
        }
    }
}
