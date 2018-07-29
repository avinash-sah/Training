package practice.july28;

import java.util.Stack;

public class Q15_InorderTraversal_stack {
    Node root;

    public static void main(String[] args) {
        Q15_InorderTraversal_stack tree = new Q15_InorderTraversal_stack();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.inorder();
    }

    private void inorder() {
        if (root == null) {
            return;
        }
        Stack<Node> nodeStack = new Stack<>();
        Node current = root;

        while (current != null || !nodeStack.isEmpty()) {
            while (current != null) {
                nodeStack.push(current);
                current = current.left;
            }
            current = nodeStack.pop();
            System.out.print(current.key + " ");
            current = current.right;

        }

    }

    static class Node {
        int key;
        Node left;
        Node right;

        Node(int pKey) {
            key = pKey;
            left = right = null;
        }
    }


}
