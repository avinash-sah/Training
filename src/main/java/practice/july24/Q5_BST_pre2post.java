package practice.july24;

public class Q5_BST_pre2post {
    Node root;

    public static void main(String[] args) {
        int pre[] = {40, 30, 35, 80, 100};
        Node root = formTree(pre);
        printOrder(root);
    }

    private static Node formTree(int[] pPre) {
        Index index = new Index(0);
        return formTreeUtil(pPre, index, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private static Node formTreeUtil(int[] pPre, Index pIndex, int pMinValue, int pMaxValue) {
        if (pIndex.pos >= pPre.length) {
            return null;
        }
        int key = pPre[pIndex.pos];
        Node root = null;

        if (pMinValue < key && key < pMaxValue) {
            pIndex.pos++;
            root = new Node(key);
            root.left = formTreeUtil(pPre, pIndex, pMinValue, key);
            root.right = formTreeUtil(pPre, pIndex, key, pMaxValue);
        }


        return root;
    }

    private static void printOrder(Node pRoot) {
        if (pRoot == null) {
            return;
        }
        printOrder(pRoot.left);
        printOrder(pRoot.right);
        System.out.print(pRoot.data + " ");
    }

    static class Node {
        int data;
        Node left, right;

        public Node(int pData) {
            data = pData;
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
