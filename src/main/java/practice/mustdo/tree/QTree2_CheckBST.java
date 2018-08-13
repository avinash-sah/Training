package practice.mustdo.tree;

public class QTree2_CheckBST {

    private Node root;

    public static void main(String[] args) {
        QTree2_CheckBST tree = new QTree2_CheckBST();
        tree.root = new Node(3);
        tree.root.left = new Node(2);
        tree.root.right = new Node(5);
        tree.root.left.left = new Node(1);
        tree.root.left.right = new Node(4);

        System.out.println(tree.isBST());
    }

    private boolean isBST() {
        return isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean isBST(Node pRoot, int pMinValue, int pMaxValue) {
        if (pRoot == null) {
            return true;
        }

        if (pRoot.data < pMinValue || pRoot.data > pMaxValue) {
            return false;
        }

        return isBST(pRoot.left, pMinValue, pRoot.data - 1) &&
                isBST(pRoot.right, pRoot.data + 1, pMaxValue);
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
