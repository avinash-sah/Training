package practice.mustdo.tree;

public class QTree9_IdenticalTree {

    private Node root1;
    private Node root2;

    public static void main(String[] args) {
        QTree9_IdenticalTree tree = new QTree9_IdenticalTree();
        tree.root1 = new Node(1);
        tree.root1.left = new Node(2);
        tree.root1.right = new Node(3);
        tree.root1.left.left = new Node(4);
        tree.root1.left.right = new Node(5);

        tree.root2 = new Node(1);
        tree.root2.left = new Node(2);
        tree.root2.right = new Node(3);
        tree.root2.left.left = new Node(4);
        tree.root2.left.right = new Node(5);

        if (tree.identicalTrees(tree.root1, tree.root2))
            System.out.println("Both trees are identical");
        else
            System.out.println("Trees are not identical");
    }

    private boolean identicalTrees(Node pRoot1, Node pRoot2) {

        if (pRoot1 == null && pRoot2 == null) {
            return true;
        }
        if (pRoot1.data == pRoot2.data &&
                identicalTrees(pRoot1.left, pRoot2.left) &&
                identicalTrees(pRoot1.right, pRoot2.right)) {
            return true;
        }

        return false;
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
