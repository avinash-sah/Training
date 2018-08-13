package practice.mustdo.tree;

public class QTree12_MaxPathSumLeaves {
    private Node root;

    public static void main(String[] args) {
        QTree12_MaxPathSumLeaves tree = new QTree12_MaxPathSumLeaves();
        tree.root = new Node(-15);
        tree.root.left = new Node(5);
        tree.root.right = new Node(6);
        tree.root.left.left = new Node(-8);
        tree.root.left.right = new Node(1);
        tree.root.left.left.left = new Node(2);
        tree.root.left.left.right = new Node(6);
        tree.root.right.left = new Node(3);
        tree.root.right.right = new Node(9);
        tree.root.right.right.right = new Node(0);
        tree.root.right.right.right.left = new Node(4);
        tree.root.right.right.right.right = new Node(-1);
        tree.root.right.right.right.right.left = new Node(10);
        System.out.println("Max pathSum of the given binary tree is "
                + tree.maxPathSum(tree.root));
    }

    private int maxPathSum(Node pRoot) {
        Max max = new Max();
        max.val = Integer.MIN_VALUE;
        findMaxPath(pRoot, max);
        return max.val;
    }

    private int findMaxPath(Node pRoot, Max pMax) {
        if (pRoot == null) {
            return 0;
        }

        if (pRoot.left == null && pRoot.right == null) {
            return pRoot.data;
        }

        int lMax = findMaxPath(pRoot.left, pMax);
        int rMax = findMaxPath(pRoot.right, pMax);

        if (pRoot.left != null && pRoot.right != null) {
            pMax.val = Math.max(pMax.val, lMax + rMax + pRoot.data);
            return Math.max(pRoot.data, Math.max(lMax, rMax) + pRoot.data);
        }

        return pRoot.left != null ? lMax + pRoot.data
                : rMax + pRoot.data;
    }

    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int pData) {
            left = right = null;
            data = pData;
        }
    }

    class Max {
        int val;
    }
}
