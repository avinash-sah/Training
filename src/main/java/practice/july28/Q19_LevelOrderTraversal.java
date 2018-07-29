package practice.july28;

public class Q19_LevelOrderTraversal {
    Node root;

    public static void main(String[] args) {
        Q19_LevelOrderTraversal tree = new Q19_LevelOrderTraversal();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);

        tree.levelTraversal();
    }

    private void levelTraversal() {
        int height = findHeight(root);
        for (int i = 1; i <= height; i++) {
            printLevelTraverse(root, i);
        }
    }

    private void printLevelTraverse(Node pRoot, int pI) {
        if (pRoot == null) {
            return;
        }
        if (pI == 1) {
            System.out.print(pRoot.key + " ");
        } else if (pI > 1) {
            printLevelTraverse(pRoot.left, pI - 1);
            printLevelTraverse(pRoot.right, pI - 1);
        }
    }

    private int findHeight(Node pRoot) {
        if (pRoot == null) {
            return 0;
        }
        int lHeight = findHeight(pRoot.left);
        int rHeight = findHeight(pRoot.right);
        if (lHeight > rHeight) {
            return lHeight + 1;
        } else {
            return rHeight + 1;
        }
    }

    static class Node {
        int key;
        Node left;
        Node right;

        public Node(int pKey) {
            key = pKey;
            left = right = null;
        }
    }
}
