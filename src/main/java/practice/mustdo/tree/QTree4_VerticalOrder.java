package practice.mustdo.tree;

import java.util.*;

public class QTree4_VerticalOrder {

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.right.left.right = new Node(8);
        root.right.right.right = new Node(9);
        System.out.println("Vertical Order traversal is");
        printVerticalOrder(root);
        System.out.println("Vertical Level Order traversal is");
        printVerticalOrder_level(root);
    }

    private static void printVerticalOrder_level(Node pRoot) {
        if (pRoot == null) {
            return;
        }
        Map<Integer, Vector<Integer>> map = new TreeMap<>();
        int hd = 0;

        Queue<Data> nodePairs = new LinkedList<>();
        nodePairs.add(new Data(pRoot, hd));

        while (!nodePairs.isEmpty()) {
            Data data = nodePairs.poll();
            hd = data.hd;
            Node temp = data.node;

            Vector<Integer> order = map.get(hd);
            if (order == null) {
                order = new Vector<>();
                map.put(hd, order);
            }
            order.add(temp.data);

            if (temp.left != null) {
                nodePairs.add(new Data(temp.left, hd - 1));
            }

            if (temp.right != null) {
                nodePairs.add(new Data(temp.right, hd + 1));
            }
        }
        for (Map.Entry<Integer, Vector<Integer>> entry : map.entrySet()) {
            for (Integer p : entry.getValue()) {
                System.out.print(p + " ");
            }
            System.out.println();
        }
    }

    private static void printVerticalOrder(Node pRoot) {
        int hd = 0;
        Map<Integer, Vector<Integer>> map = new TreeMap<>();
        getVerticalOrder(pRoot, hd, map);

        for (Map.Entry<Integer, Vector<Integer>> entry : map.entrySet()) {
            for (Integer p : entry.getValue()) {
                System.out.print(p + " ");
            }
            System.out.println();
        }
    }

    private static void getVerticalOrder(Node pRoot, int pHd, Map<Integer, Vector<Integer>> pMap) {

        if (pRoot == null) {
            return;
        }

        Vector<Integer> order = pMap.get(pHd);

        if (order == null) {
            order = new Vector<>();
            pMap.put(pHd, order);
        }
        order.add(pRoot.data);

        getVerticalOrder(pRoot.left, pHd - 1, pMap);
        getVerticalOrder(pRoot.right, pHd + 1, pMap);
    }

    static class Data {
        Node node;
        int hd;

        public Data(Node pNode, int pHd) {
            node = pNode;
            hd = pHd;
        }
    }

    static class Node {
        int data;
        Node left, right;

        public Node(int pData) {
            data = pData;
            left = right = null;
        }
    }
}
