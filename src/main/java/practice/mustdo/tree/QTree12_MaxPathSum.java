package practice.mustdo.tree;

public class QTree12_MaxPathSum {
    private Node root;

    public static void main(String[] args) {
        QTree12_MaxPathSum tree = new QTree12_MaxPathSum();
        tree.root = new Node(10);
        tree.root.left = new Node(2);
        tree.root.right = new Node(10);
        tree.root.left.left = new Node(20);
        tree.root.left.right = new Node(1);
        tree.root.right.right = new Node(-25);
        tree.root.right.right.left = new Node(3);
        tree.root.right.right.right = new Node(4);
        System.out.println("maximum path sum is : " +
                tree.findMaxSum());
    }

    private int findMaxSum() {
        Max max = new Max(Integer.MIN_VALUE);
        findMaxSumUtil(root, max);
        return max.val;
    }

    private int findMaxSumUtil(Node pRoot, Max pMax) {
        if (pRoot == null) {
            return 0;
        }

        int lMax = findMaxSumUtil(pRoot.left, pMax);
        int rMax = findMaxSumUtil(pRoot.right, pMax);
        int max_single = Math.max(pRoot.data, Math.max(lMax, rMax) + pRoot.data);
        int max_top = Math.max(max_single, lMax + rMax + pRoot.data);
        pMax.val = Math.max(pMax.val, max_top);
        return max_single;
    }

    static class Max {
        int val;

        public Max(int pVal) {
            val = pVal;
        }
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
