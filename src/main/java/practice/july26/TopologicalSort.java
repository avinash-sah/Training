package practice.july26;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class TopologicalSort {
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
            boolean[] visited = new boolean[V];
            Arrays.fill(visited, false);

            Stack<Integer> resultStack = new Stack<>();

            for (int i = 0; i < V; i++) {
                if (!visited[i]) {
                    topologicalSortUtil(i, visited, resultStack);
                }
            }

            while (!resultStack.isEmpty()) {
                System.out.print(resultStack.pop() + " ");
            }
            System.out.println();
        }

        private void topologicalSortUtil(int pI, boolean[] pVisited, Stack<Integer> pResultStack) {
            pVisited[pI] = true;
            for (int i : adjacency[pI]) {
                if (!pVisited[i]) {
                    topologicalSortUtil(i, pVisited, pResultStack);
                }
            }
            pResultStack.push(pI);
        }
    }

}
