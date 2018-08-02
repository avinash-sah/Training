package practice.aug01;

/**
 * Given a  Binary Tree, find the difference between the sum of nodes
 * at odd level and the sum of nodes at even level.
 * Consider root as level 1, left and right children of root as level 2 and so on.
 * <p>
 * For example, in the following tree, sum of nodes at odd level is (5 + 1 + 4 + 8) which is 18.
 * And sum of nodes at even level is (2 + 6 + 3 + 7 + 9) which is 27.
 * The output for following tree should be 18 – 27 which is -9.
 */
public class Q3_TreeLevelEvenOdd {
    Node root;

    public static void main(String[] args) {
        Q3_TreeLevelEvenOdd tree = new Q3_TreeLevelEvenOdd();
        tree.root = newNode(5);
        Node root = tree.root;
        root.left = newNode(2);
        root.right = newNode(6);
        root.left.left = newNode(1);
        root.left.right = newNode(4);
        root.left.right.left = newNode(3);
        root.right.right = newNode(8);
        root.right.right.right = newNode(9);
        root.right.right.left = newNode(7);

        System.out.println(diffOddEven(root));
    }

    private static int diffOddEven(Node pRoot) {
        if (pRoot == null) {
            return 0;
        }
        return pRoot.data //level 1
                - diffOddEven(pRoot.left) - diffOddEven(pRoot.right);//level 2
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
}
