package practice.july29;

public class Q5_SwapKinLL {

    Node head;

    public static void main(String[] args) {
        Q5_SwapKinLL llist = new Q5_SwapKinLL();
        for (int i = 8; i >= 1; i--)
            llist.push(i);

        System.out.print("Original linked list: ");
        llist.printList();
        System.out.println("");

        for (int i = 1; i < 9; i++) {
            llist.swapKth(i);
            System.out.println("Modified List for k = " + i);
            llist.printList();
            System.out.println();
        }
    }

    private void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    private void push(int pData) {
        Node node = new Node(pData);
        node.next = head;
        head = node;
    }

    private int size() {
        Node node = head;
        int size = 0;
        while (node != null) {
            size++;
            node = node.next;
        }
        return size;
    }

    private void swapKth(int k) {
        if (head == null) {
            return;
        }
        int n = size();
        if (n < k || k == n - k + 1) {
            return;
        }

        Node x = head;
        Node x_prev = null;
        //Not 0 but 1
        for (int i = 1; i < k; i++) {
            x_prev = x;
            x = x.next;
        }

        Node y = head;
        Node y_prev = null;
        for (int i = 1; i < n - k + 1; i++) {
            y_prev = y;
            y = y.next;
        }

        if (x_prev != null) {
            x_prev.next = y;
        } else {
            head = y;
        }

        if (y_prev != null) {
            y_prev.next = x;
        } else {
            head = x;
        }

        Node temp = x.next;
        x.next = y.next;
        y.next = temp;
    }

    static class Node {
        int data;
        Node next;

        public Node(int pData) {
            next = null;
            data = pData;
        }
    }
}
