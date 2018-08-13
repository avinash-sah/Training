package practice.mustdo.tree;

import java.util.LinkedList;
import java.util.Queue;

public class QTree14_CountLeaves {
    Node root;

    public static void main(String[] args) {
        QTree14_CountLeaves tree = new QTree14_CountLeaves();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        System.out.println(tree.countLeaves(tree.root));
        System.out.println(tree.countLeaves_i(tree.root));
    }

    int countLeaves(Node pRoot) {
        if (pRoot == null) {
            return 0;
        }
        if (pRoot.left == null && pRoot.right == null) {
            return 1;
        }
        return countLeaves(pRoot.left) +
                countLeaves(pRoot.right);
    }

    int countLeaves_i(Node pRoot) {
        if (pRoot == null) {
            return 0;
        }
        int count = 0;

        Queue<Node> nodeQueue = new LinkedList<>();
        nodeQueue.add(pRoot);

        while (!nodeQueue.isEmpty()) {
            Node temp = nodeQueue.poll();

            if (temp.right == null && temp.left == null) {
                count++;
            }
            if (temp.left != null) {
                nodeQueue.add(temp.left);
            }
            if (temp.right != null) {
                nodeQueue.add(temp.right);
            }
        }
        return count;
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
