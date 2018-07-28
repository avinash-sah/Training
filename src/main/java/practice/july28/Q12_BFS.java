package practice.july28;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Q12_BFS {

    public static void main(String[] args) {

        Graph g = new Graph(5);

      /*  g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);*/

        g.addEdge(1, 0);
        g.addEdge(0, 2);
        g.addEdge(2, 1);
        g.addEdge(0, 3);
        g.addEdge(1, 4);

        g.BFS(0);
    }

    static class Graph {
        private int v;
        private List<Integer> adj[];

        Graph(int pV) {
            v = pV;
            adj = new LinkedList[v];
            for (int i = 0; i < v; i++) {
                adj[i] = new LinkedList<>();
            }
        }

        void addEdge(int v, int w) {
            adj[v].add(w);
        }

        void BFS(int s) {
            boolean[] visited = new boolean[v];

            Queue<Integer> queue = new LinkedList<>();
            visited[s] = true;
            queue.add(s);

            while (!queue.isEmpty()){
                s = queue.poll();
                System.out.print(s + " ");

                Iterator<Integer> pIterator = adj[s].listIterator();
                while (pIterator.hasNext()){
                    Integer q = pIterator.next();
                    if(!visited[q]){
                        visited[q] = true;
                        queue.add(q);
                    }
                }

            }
        }

    }
}
