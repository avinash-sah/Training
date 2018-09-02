package practice.mustdo.linkedlist;

public class Qll_FlattenList {

    Node head;

    public static void main(String[] args) {
        Qll_FlattenList L = new Qll_FlattenList();

        /* Let us create the following linked list
            5 -> 10 -> 19 -> 28
            |    |     |     |
            V    V     V     V
            7    20    22    35
            |          |     |
            V          V     V
            8          50    40
            |                |
            V                V
            30               45
        */

        L.head = L.push(L.head, 30);
        L.head = L.push(L.head, 8);
        L.head = L.push(L.head, 7);
        L.head = L.push(L.head, 5);

        L.head.right = L.push(L.head.right, 20);
        L.head.right = L.push(L.head.right, 10);

        L.head.right.right = L.push(L.head.right.right, 50);
        L.head.right.right = L.push(L.head.right.right, 22);
        L.head.right.right = L.push(L.head.right.right, 19);

        L.head.right.right.right = L.push(L.head.right.right.right, 45);
        L.head.right.right.right = L.push(L.head.right.right.right, 40);
        L.head.right.right.right = L.push(L.head.right.right.right, 35);
        L.head.right.right.right = L.push(L.head.right.right.right, 28);

        // flatten the list
        L.head = L.flatten(L.head);

        L.printList();
    }

    private Node flatten(Node pHead) {

        if(pHead == null || pHead.right == null){
            return pHead;
        }

        pHead.right = flatten(pHead.right);
        return merge(pHead, pHead.right);
    }

    private Node merge(Node left, Node right) {
        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }

        Node result;
        if (left.data < right.data) {
            result = left;
            result.down = merge(left.down, right);
        } else {
            result = right;
            result.down = merge(left, right.down);
        }
        return result;
    }

    private void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.down;
        }
        System.out.println();
    }

    private Node push(Node pHead, int pI) {
        Node temp = new Node(pI);
        temp.down = pHead;
        pHead = temp;
        return pHead;
    }

    class Node {
        int data;
        Node right;
        Node down;

        public Node(int pData) {
            data = pData;
            right = null;
            down = null;
        }
    }
}
