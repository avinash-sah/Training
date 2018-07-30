package practice.july29;

public class Q1_Dijkstra {

    int V;

    public static void main(String[] args) {
        int graph[][] = new int[][]{
                {0, 4, 0, 0, 0, 0, 0, 8, 0},
                {4, 0, 8, 0, 0, 0, 0, 11, 0},
                {0, 8, 0, 7, 0, 4, 0, 0, 2},
                {0, 0, 7, 0, 9, 14, 0, 0, 0},
                {0, 0, 0, 9, 0, 10, 0, 0, 0},
                {0, 0, 4, 14, 10, 0, 2, 0, 0},
                {0, 0, 0, 0, 0, 2, 0, 1, 6},
                {8, 11, 0, 0, 0, 0, 1, 0, 7},
                {0, 0, 2, 0, 0, 0, 6, 7, 0}
        };
        Q1_Dijkstra t = new Q1_Dijkstra();
        t.dijkstra(graph, 0);
    }

    private int minItem(boolean[] mst, int[] dist) {
        int min = Integer.MAX_VALUE;
        int index = -1;

        for (int i = 0; i < V; i++) {
            if (!mst[i] && dist[i] < min) {
                min = dist[i];
                index = i;
            }
        }
        return index;
    }

    private void dijkstra(int[][] pGraph, int pI) {
        V = 9;
        boolean[] mst = new boolean[V];
        int[] dist = new int[V];

        for (int i = 0; i < V; i++) {
            mst[i] = false;
            dist[i] = Integer.MAX_VALUE;
        }
        dist[pI] = 0;

        for (int i = 1; i < V - 1; i++) {
            int u = minItem(mst, dist);
            mst[u] = true;

            for (int j = 0; j < V; j++) {
                if (!mst[j]
                        && pGraph[u][j] != 0
                        && dist[u] != Integer.MAX_VALUE
                        && dist[u] + pGraph[u][j] < dist[j]) {
                    dist[j] = dist[u] + pGraph[u][j];
                }

            }
        }

        printSolution(dist);
    }

    private void printSolution(int[] pDist) {
        for (int i = 0; i < V; i++) {
            System.out.println(i + "- " + pDist[i]);
        }
    }
}
