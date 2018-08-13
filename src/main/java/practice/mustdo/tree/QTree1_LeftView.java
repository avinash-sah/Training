package practice.mustdo.tree;

public class QTree1_LeftView {

    Node root;
    int maxLevel;

    public static void main(String[] args) {
        QTree1_LeftView tree = new QTree1_LeftView();
        tree.root = new Node(12);
        tree.root.left = new Node(10);
        tree.root.right = new Node(30);
        tree.root.right.left = new Node(25);
        tree.root.right.right = new Node(40);
        tree.leftView();
    }

    private void leftView() {
        maxLevel = 0;
        leftViewUtil(root, 1);
    }

    private void leftViewUtil(Node root, int pLevel) {
        if (root == null) {
            return;
        }

        if (maxLevel < pLevel) {
            System.out.print(root.data + " ");
            maxLevel = pLevel;
        }

        leftViewUtil(root.left, pLevel + 1);
        leftViewUtil(root.right, pLevel + 1);
    }

    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int pData) {
            data = pData;
            left = null;
            right = null;
        }
    }
}
