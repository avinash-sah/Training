package practice.july29;

public class Q7_SortedLL {

    Node head;

    public static void main(String[] args) {
        Q7_SortedLL ll = new Q7_SortedLL();
        ll.put(5);
        ll.printLL();
        ll.put(10);
        ll.printLL();
        ll.put(7);
        ll.printLL();
        ll.put(3);
        ll.printLL();
        ll.put(1);
        ll.printLL();
        ll.put(9);
        ll.printLL();
    }

    void put(int pData) {
        Node newNode = new Node(pData);
        if (head == null || head.data > pData) {
            newNode.next = head;
            head = newNode;
        } else {
            Node curr = head;
            while (curr.next != null && curr.next.data < pData) {
                curr = curr.next;
            }
            newNode.next = curr.next;
            curr.next = newNode;
        }
    }

    void printLL() {
        Node itr = head;
        while (itr != null) {
            System.out.print(itr.data + " ");
            itr = itr.next;
        }
        System.out.println();
    }

    static class Node {
        int data;
        Node next;

        public Node(int pData) {
            data = pData;
            next = null;
        }
    }
}
