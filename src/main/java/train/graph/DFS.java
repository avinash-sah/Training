package train.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DFS {

    private Map<String, List<Node>> adjList;

    public DFS() {
        adjList = new HashMap<>();
    }

    public static void main(String[] args) {
        DFS dfs = new DFS();
        dfs.addEdge("Domlur", "Indiranagar", 20);
        dfs.addEdge("Indiranagar", "BTM", 25);
        dfs.addEdge("BTM", "Malleshwaram", 20);
        dfs.addEdge("Indiranagar", "Malleshwaram", 10);
        dfs.addEdge("Domlur","Malleshwaram", 50 );
        dfs.addEdge("Domlur", "Marathahalli", 30);
        dfs.addEdge("Marathahalli", "BTM", 5);
        dfs.addEdge("Malleshwaram", "Marathahalli", 15);
        dfs.printAll("Domlur", "Malleshwaram");


/*        DFS ndDfs = new DFS();
        ndDfs.addEdge("Domulur", "Indiranagar", 20);
        ndDfs.addEdge("Domulur", "BTM", 10);
        ndDfs.addEdge("BTM", "Indiranagar", 10);
        ndDfs.printAll("Domulur", "Indiranagar");*/


    }

    public void addEdge(String src, String des, int fare) {
        adjList
                .computeIfAbsent(src, k -> new ArrayList<>())
                .add(new Node(des, fare));
    }

    private void printAll(String src, String dest) {
        Map<String, Boolean> visited = new HashMap<>();
        adjList.forEach((k, v) -> visited.putIfAbsent(k, false));
        visited.putIfAbsent(dest, false);
        List<Node> paths = new ArrayList<>();
        Node destination = new Node(dest, 0);
        Node source = new Node(src, 0);
        dfsUtil(source, destination, visited, paths);

    }

    private void dfsUtil(Node src, Node dest, Map<String, Boolean> visited, List<Node> path) {
        visited.put(src.location, true);
        path.add(src);

        if (src.location.equals(dest.location)) {
            printPath(path);
            return;
        }

        for (Node node : adjList.get(src.location)) {
            Boolean isVis = visited.get(node.location);
            if (isVis != null && !isVis) {
                dfsUtil(node, dest, visited, path);
                path.remove(node);
                visited.put(node.location, false);
            }
        }
    }

    private void printPath(List<Node> path) {
        int sum = 0;
        for (Node node : path) {
            System.out.print(node.location + " ");
            sum += node.fare;
        }
        System.out.println(sum);
    }

    static class Node {
        String location;
        int fare;

        public Node(String location, int fare) {
            this.location = location;
            this.fare = fare;
        }
    }
}
