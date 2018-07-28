package practice.july28;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Q14_DFS {
    public static void main(String[] args) {
        Graph g = new Graph(7);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);
        g.addEdge(2, 4);
        g.addEdge(1, 5);
        g.addEdge(3, 6);

        System.out.println("Following is Depth First Traversal " +
                "(starting from vertex 2)");

        g.DFS(2);
    }

    static class Graph {
        int v;
        List<Integer> adj[];

        Graph(int pV) {
            v = pV;
            adj = new LinkedList[v];
            for (int i = 0; i < v; i++) {
                adj[i] = new LinkedList<>();
            }
        }

        void addEdge(int v, int e) {
            adj[v].add(e);
        }

        void DFS(int pS) {
            boolean visited[] = new boolean[v];
            dfsUtil(visited, pS);
        }

        private void dfsUtil(boolean[] pVisited, int pS) {
            pVisited[pS] = true;
            System.out.print(pS + " ");

            Iterator<Integer> iterator = adj[pS].listIterator();
            while (iterator.hasNext()) {
                int s = iterator.next();
                if (!pVisited[s]) {
                    dfsUtil(pVisited, s);
                }
            }

        }
    }
}
