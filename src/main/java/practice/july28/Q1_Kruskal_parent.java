package practice.july28;

import java.util.Arrays;

public class Q1_Kruskal_parent {

    public static void main(String[] args) {
        int V = 4;  // Number of vertices in graph
        int E = 5;  // Number of edges in graph
        Graph graph = new Graph(V, E);

        // add edge 0-1
        graph.edge[0].src = 0;
        graph.edge[0].dest = 1;
        graph.edge[0].weight = 10;

        // add edge 0-2
        graph.edge[1].src = 0;
        graph.edge[1].dest = 2;
        graph.edge[1].weight = 6;

        // add edge 0-3
        graph.edge[2].src = 0;
        graph.edge[2].dest = 3;
        graph.edge[2].weight = 5;

        // add edge 1-3
        graph.edge[3].src = 1;
        graph.edge[3].dest = 3;
        graph.edge[3].weight = 15;

        // add edge 2-3
        graph.edge[4].src = 2;
        graph.edge[4].dest = 3;
        graph.edge[4].weight = 4;

        graph.KruskalMST();
    }

    static class Edge implements Comparable<Edge> {
        int src;
        int dest;
        int weight;

        @Override
        public int compareTo(Edge o) {
            return weight - o.weight;
        }
    }

    static class Graph {
        int V;
        int E;
        Edge[] edge;

        Graph(int pV, int pE) {
            V = pV;
            E = pE;
            edge = new Edge[E];
            for (int i = 0; i < E; i++) {
                edge[i] = new Edge();
            }

        }

        public void KruskalMST() {
            int[] parent = new int[V];
            Edge[] result = new Edge[V];
            for (int i = 0; i < V; i++) {
                parent[i] = -1;
            }

            Arrays.sort(edge);

            int i = 0;
            int e = 0;

            while (e < V - 1) {
                Edge next_edge = edge[i];
                i++;

                int x = find(parent, next_edge.src);
                int y = find(parent, next_edge.dest);

                if (x != y) {
                    result[e] = next_edge;
                    union(x, y, parent);
                    e++;
                }
            }

            for (int j = 0; j < e; j++) {
                System.out.println(result[j].src + " - " + result[j].dest + " " + result[j].weight);
            }

        }

        private void union(int pX, int pY, int[] pParent) {
            int x = find(pParent, pX);
            int y = find(pParent, pY);
            pParent[x] = y;
        }

        private int find(int[] pParent, int pV) {
            if (pParent[pV] == -1) {
                return pV;
            }
            return find(pParent, pParent[pV]);
        }
    }
}
