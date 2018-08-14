package practice.mustdo.tree;

public class QTree15_HeightBalanced {

    private Node root;

    public static void main(String[] args) {
        Height height = new Height();

        /* Constructed binary tree is
                   1
                 /   \
                2      3
              /  \    /
            4     5  6
            /
           7         */
        QTree15_HeightBalanced tree = new QTree15_HeightBalanced();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.right = new Node(6);
        tree.root.left.left.left = new Node(7);

        if (tree.isBalanced(tree.root, height))
            System.out.println("Tree is balanced");
        else
            System.out.println("Tree is not balanced");
    }

    private boolean isBalanced(Node pRoot, Height pHeight) {
        if (pRoot == null) {
            pHeight.h = 0;
            return true;
        }

        Height lHeight = new Height();
        Height rHeight = new Height();

        boolean l = isBalanced(pRoot.left, lHeight);
        boolean r = isBalanced(pRoot.right, rHeight);

        pHeight.h = Math.max(lHeight.h, rHeight.h) + 1;

        if (Math.abs(lHeight.h - rHeight.h) >= 2) {
            return false;
        }
        return l && r;
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

    static class Height {
        int h;
    }
}
