package practice.july28;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

public class Q13_DFS_Iterative {
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
        System.out.println("Following is the Depth First Traversal");
        g.DFS(2);
    }

    static class Graph {
        int v;
        LinkedList<Integer> adj[];

        Graph(int pV) {
            v = pV;
            adj = new LinkedList[v];
            for (int i = 0; i < v; i++) {
                adj[i] = new LinkedList<>();
            }
        }

        void addEdge(int pV, int pW) {
            adj[pV].add(pW);
        }

        public void DFS(int pS) {

            boolean visited[] = new boolean[v];
            Stack<Integer> stack = new Stack<>();
            stack.push(pS);

            while (!stack.isEmpty()) {
                pS = stack.pop();

                if (!visited[pS]) {
                    System.out.print(pS + " ");
                    visited[pS] = true;
                }

                for (Integer v : adj[pS]) {
                    if (!visited[v]) {
                        stack.push(v);
                    }
                }

            }
        }
    }
}
