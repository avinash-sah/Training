package practice.july25;

public class Q7_LeavesDLL {
    Node root;
    Node head;
    Node curr;

    public static void main(String args[]) {
        Q7_LeavesDLL tree = new Q7_LeavesDLL();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);

        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.right = new Node(6);
        tree.root.left.left.left = new Node(7);
        tree.root.left.left.right = new Node(8);
        tree.root.right.right.left = new Node(9);
        tree.root.right.right.right = new Node(10);

        System.out.println("Inorder traversal of given tree is : ");
        tree.inorder(tree.root);
        tree.extractLeafList(tree.root);
        System.out.println("");
        System.out.println("Extracted double link list is : ");
        tree.printDLL(tree.head);
        System.out.println("");
        System.out.println("Inorder traversal of modified tree is : ");
        tree.inorder(tree.root);
    }

    private void printDLL(Node pHead) {
        if (pHead == null) {
            return;
        }
        while (pHead != null) {
            System.out.print(pHead.data + " ");
            pHead = pHead.right;
        }
    }

    private Node extractLeafList(Node pRoot) {
        if (pRoot == null) {
            return null;
        }
        if (pRoot.left == null && pRoot.right == null) {
            if (head == null) {
                head = pRoot;
                curr = pRoot;
            } else {
                curr.right = pRoot;
                pRoot.left = curr;
                curr = pRoot;
            }
            return null;
        }
        pRoot.left = extractLeafList(pRoot.left);
        pRoot.right = extractLeafList(pRoot.right);
        return pRoot;
    }

    private void inorder(Node pRoot) {
        if (pRoot == null) {
            return;
        }
        inorder(pRoot.left);
        System.out.print(pRoot.data + " ");
        inorder(pRoot.right);
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
