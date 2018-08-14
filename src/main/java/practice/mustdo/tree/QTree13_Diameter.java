package practice.mustdo.tree;

public class QTree13_Diameter {
    private Node root;

    public static void main(String[] args) {
        QTree13_Diameter tree = new QTree13_Diameter();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        System.out.println(tree.diameter());
    }

    private int diameter() {
        Height height = new Height();
        return diameterUtil(root, height);
    }

    private int diameterUtil(Node pRoot, Height pHeight) {
        if (pRoot == null) {
            pHeight.h = 0;
            return 0;
        }

        Height lh = new Height();
        Height rh = new Height();

        int ld = diameterUtil(pRoot.left, lh);
        int rd = diameterUtil(pRoot.right, rh);
        pHeight.h = Math.max(lh.h, rh.h) + 1;

        return Math.max(lh.h + rh.h + 1, Math.max(ld, rd));
    }

    static class Node {
        int data;
        Node left, right;

        public Node(int pData) {
            data = pData;
            left = right = null;
        }
    }

    class Height {
        int h;
    }
}
