package practice.aug01;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a Binary Tree having positive and negative nodes, the task is to find maximum sum level in it.
 */
public class Q9_MaxSumAtLevel {

    Node root;

    public static void main(String[] args) {
        Q9_MaxSumAtLevel tree = new Q9_MaxSumAtLevel();
        tree.root = newNode(4);
        Node root = tree.root;
        root.left = newNode(2);
        root.right = newNode(-5);
        root.left.left = newNode(-1);
        root.left.right = newNode(3);
        root.right.left = newNode(-2);
        root.right.right = newNode(6);

        System.out.println(maxSum(root));
        System.out.println(tree.getMaxWidth(tree.root));
    }

    private static int maxSum(Node pRoot) {
        Queue<Node> nodes = new LinkedList<>();
        nodes.add(pRoot);
        int max = Integer.MIN_VALUE;

        while (!nodes.isEmpty()) {
            int count = nodes.size();
            int sum = 0;
            while (count > 0) {
                count--;
                Node temp = nodes.remove();
                sum += temp.data;
                if (temp.left != null) {
                    nodes.add(temp.left);
                }
                if (temp.right != null) {
                    nodes.add(temp.right);
                }
            }
            if (max < sum) {
                max = sum;
            }
        }
        return max;
    }

    private static Node newNode(int pI) {
        return new Node(pI);
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

    /* Function to get the maximum width of a binary tree*/
    int getMaxWidth(Node node)
    {
        int maxWidth = 0;
        int width;
        int h = height(node);
        int i;

        /* Get width of each level and compare
           the width with maximum width so far */
        for (i = 1; i <= h; i++)
        {
            width = getWidth(node, i);
            if (width > maxWidth)
                maxWidth = width;
        }

        return maxWidth;
    }

    /* Get width of a given level */
    int getWidth(Node node, int level)
    {
        if (node == null)
            return 0;

        if (level == 1)
            return node.data;
        else if (level > 1)
            return getWidth(node.left, level - 1)
                    + getWidth(node.right, level - 1);
        return 0;
    }

    /* UTILITY FUNCTIONS */

    /* Compute the "height" of a tree -- the number of
     nodes along the longest path from the root node
     down to the farthest leaf node.*/
    int height(Node node)
    {
        if (node == null)
            return 0;
        else
        {
            /* compute the height of each subtree */
            int lHeight = height(node.left);
            int rHeight = height(node.right);

            /* use the larger one */
            return (lHeight > rHeight) ? (lHeight + 1) : (rHeight + 1);
        }
    }
}
