package practice.july24;

public class Q5_TreeFromPre {
    Node root;

    public static void main(String[] args) {
        Q5_TreeFromPre tree = new Q5_TreeFromPre();
        int pre[] = new int[]{10, 5, 1, 7, 40, 50};
        tree.root = formTree(pre);
        tree.inorder(tree.root);
    }

    private static Node formTree(int[] pPre) {
        Index index = new Index(0);
        return formTreeUtil(pPre, index, 0, pPre.length - 1);
    }

    private static Node formTreeUtil(int[] pPre, Index pIndex, int pLow, int pHigh) {

        if (pIndex.pos > pPre.length || pHigh < pLow) {
            return null;
        }

        int src = pPre[pIndex.pos];
        Node root = new Node(src);
        pIndex.pos++;

        if (pLow == pHigh) {
            return root;
        }

        int i;
        for (i = pLow; i <= pHigh; i++) {
            if (pPre[i] > root.key) {
                break;
            }
        }

        root.left = formTreeUtil(pPre, pIndex, pIndex.pos, i - 1);
        root.right = formTreeUtil(pPre, pIndex, i, pHigh);
        return root;
    }

    private void inorder(Node pNode) {
        if (pNode == null) {
            return;
        }
        inorder(pNode.left);
        System.out.print(pNode.key + " ");
        inorder(pNode.right);
    }

    static class Node {
        int key;
        Node left, right;

        public Node(int pKey) {
            key = pKey;
            left = right = null;
        }
    }

    static class Index {
        int pos;

        public Index(int pPos) {
            pos = pPos;
        }
    }
}
