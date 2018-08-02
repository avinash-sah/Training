package practice.aug01;

/**
 * Given a Binary Tree, print all nodes that don’t have a sibling (a sibling is a node that has same parent.
 * In a Binary Tree, there can be at most one sibling).
 * Root should not be printed as root cannot have a sibling
 */
public class Q7_Siblings {
    private Node root;

    public static void main(String[] args) {
        Q7_Siblings tree = new Q7_Siblings();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.right = new Node(4);
        tree.root.right.left = new Node(5);
        tree.root.right.left.right = new Node(6);
        tree.printSingles(tree.root);
    }

    private void printSingles(Node pRoot) {
        if (pRoot == null) {
            return;
        }
        if (pRoot.left != null && pRoot.right != null) {
            printSingles(pRoot.left);
            printSingles(pRoot.right);
        } else if (pRoot.right != null) {
            System.out.println(pRoot.right.data);
            printSingles(pRoot.right);
        } else if (pRoot.left != null) {
            System.out.println(pRoot.left.data);
            printSingles(pRoot.left);
        }
    }

    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int pData) {
            data = pData;
            left = right = null;
        }
    }
}
