package practice.mustdo.tree;

import java.util.*;

public class QTree3_BottomView {

    private Node root;

    public static void main(String[] args) {
        Node root = new Node(20);
        root.left = new Node(8);
        root.right = new Node(22);
        root.left.left = new Node(5);
        root.left.right = new Node(3);
        root.right.left = new Node(4);
        root.right.right = new Node(25);
        root.left.right.left = new Node(10);
        root.left.right.right = new Node(14);
        QTree3_BottomView tree = new QTree3_BottomView();
        tree.root = root;
        System.out.println("Bottom view of the given binary tree:");
        tree.bottomView();
    }

    private void bottomView() {
        if (root == null) {
            return;
        }

        int hd = 0;
        Map<Integer, Integer> map = new TreeMap<>();
        Queue<Node> nodeQueue = new LinkedList<>();
        root.hd = hd;
        nodeQueue.add(root);


        while (!nodeQueue.isEmpty()) {
            Node node = nodeQueue.remove();
            hd = node.hd;

            map.put(hd, node.data);

            if (node.left != null) {
                node.left.hd = hd - 1;
                nodeQueue.add(node.left);
            }

            if (node.right != null) {
                node.right.hd = hd + 1;
                nodeQueue.add(node.right);
            }
        }

        Set<Map.Entry<Integer, Integer>> set = map.entrySet();
        for (Map.Entry<Integer, Integer> entry: set) {
            System.out.print(entry.getValue() + " ");
        }
        System.out.println();

    }

    static class Node {
        int data;
        Node left, right;
        int hd;

        public Node(int pData) {
            data = pData;
            left = right = null;
        }
    }
}
