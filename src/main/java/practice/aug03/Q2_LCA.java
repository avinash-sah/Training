package practice.aug03;

/**
 * Given values of two values n1 and n2 in a Binary Search Tree,
 * find the Lowest Common Ancestor (LCA).
 * You may assume that both the values exist in the tree.
 */
public class Q2_LCA {

    Node root;

    public static void main(String[] args) {
        Q2_LCA tree = new Q2_LCA();
        tree.root = new Node(20);
        tree.root.left = new Node(8);
        tree.root.right = new Node(22);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(12);
        tree.root.left.right.left = new Node(10);
        tree.root.left.right.right = new Node(14);

        int n1 = 10, n2 = 14;
        Node t = tree.lca(tree.root, n1, n2);
        System.out.println("LCA of " + n1 + " and " + n2 + " is " + t.data);

        n1 = 14;
        n2 = 8;
        t = tree.lca(tree.root, n1, n2);
        System.out.println("LCA of " + n1 + " and " + n2 + " is " + t.data);

        n1 = 10;
        n2 = 22;
        t = tree.lca(tree.root, n1, n2);
        System.out.println("LCA of " + n1 + " and " + n2 + " is " + t.data);
    }

    Node lca(Node pRoot, int n1, int n2) {
        if (pRoot == null) {
            return null;
        }
        if (pRoot.data < n1 && pRoot.data < n2) {
            return lca(pRoot.right, n1, n2);
        }
        if (pRoot.data > n1 && pRoot.data > n2) {
            return lca(pRoot.left, n1, n2);
        }
        return pRoot;
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
