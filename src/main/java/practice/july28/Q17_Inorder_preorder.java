package practice.july28;

public class Q17_Inorder_preorder {
    Node head;

    public static void main(String[] args) {
        Q17_Inorder_preorder tree = new Q17_Inorder_preorder();
        char in[] = new char[]{'D', 'B', 'E', 'A', 'F', 'C'};
        char pre[] = new char[]{'A', 'B', 'D', 'E', 'C', 'F'};
        tree.head = tree.formTree(pre, 0, pre.length - 1, in, 0, in.length - 1);
        tree.inorder(tree.head);
    }

    private Node formTree(char[] pPre, int preStart, int preEnd, char[] pIn, int inStart, int inEnd) {
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }
        Node root = new Node(pPre[preStart]);

        int k = 0;
        for (int i = 0; i < pIn.length; i++) {
            if (root.key == pIn[i]) {
                k = i;
                break;
            }
        }

        root.left = formTree(pPre, preStart + 1, preStart + (k - inStart), pIn, inStart, k - 1);
        root.right = formTree(pPre, preStart + (k - inStart) + 1, preEnd, pIn, k + 1, inEnd);
        return root;

    }


    void inorder(Node pNode) {
        if (pNode == null) {
            return;
        }
        inorder(pNode.left);
        System.out.print(pNode.key + " ");
        inorder(pNode.right);
    }

    static class Node {
        char key;
        Node left, right;

        Node(char pKey) {
            key = pKey;
            left = null;
            right = null;
        }
    }
}
