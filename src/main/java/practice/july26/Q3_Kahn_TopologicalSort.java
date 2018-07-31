package practice.july26;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Q3_Kahn_TopologicalSort {
    public static void main(String[] args) {
        Graph g = new Graph(6);
        g.addEdge(5, 2);
        g.addEdge(5, 0);
        g.addEdge(4, 0);
        g.addEdge(4, 1);
        g.addEdge(2, 3);
        g.addEdge(3, 1);
        System.out.println("Following is a Topological Sort");
        g.topologicalSort();
    }

    static class Graph {
        int V;
        List<Integer> adjacency[];

        public Graph(int pV) {
            V = pV;
            adjacency = new List[V];
            for (int i = 0; i < V; i++) {
                adjacency[i] = new ArrayList<>();
            }
        }

        void addEdge(int u, int v) {
            adjacency[u].add(v);
        }

        public void topologicalSort() {
            int[] inDegree = new int[V];
            for (int i : inDegree) {
                i = 0;
            }

            for (int i = 0; i < V; i++) {
                List<Integer> list = adjacency[i];
                for (int v : list) {
                    inDegree[v]++;
                }
            }

            Queue<Integer> queue = new LinkedList<>();
            for (int i = 0; i < V; i++) {
                if (inDegree[i] == 0) {
                    queue.add(i);
                }

            }
            int count = 0;
            List<Integer> result = new ArrayList<>();
            while (!queue.isEmpty()) {
                int u = queue.poll();

                for (Integer i : adjacency[u]) {
                    --inDegree[i];
                    if (inDegree[i] == 0) {
                        queue.add(i);
                    }
                }
                result.add(u);
                count++;
            }
            if (count < V) {
                System.out.println("No topological sort");
                return;
            }

            for (int i: result) {
                System.out.print(i + " " );
            }
        }
    }

}
