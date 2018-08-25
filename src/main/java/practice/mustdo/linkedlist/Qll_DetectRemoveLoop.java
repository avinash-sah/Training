package practice.mustdo.linkedlist;

public class Qll_DetectRemoveLoop {

    Node head;

    public static void main(String[] args) {
        Qll_DetectRemoveLoop list = new Qll_DetectRemoveLoop();
        list.head = new Node(50);
        list.head.next = new Node(20);
        list.head.next.next = new Node(15);
        list.head.next.next.next = new Node(4);
        list.head.next.next.next.next = new Node(10);

        // Creating a loop for testing
        list.head.next.next.next.next.next = list.head.next.next;
        list.detectAndRemoveLoop(list.head);
        System.out.println("Linked List after removing loop : ");
        list.printList(list.head);
    }

    private void printList(Node pHead) {
        while (pHead != null) {
            System.out.print(pHead.key + " ");
            pHead = pHead.next;
        }
    }

    private void detectAndRemoveLoop(Node pHead) {
        Node slow = pHead;
        Node fast = pHead;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                break;
            }
        }

        if (slow == fast) {
            System.out.println("Loop present");
            slow = pHead;
            while (slow.next != fast.next) {
                slow = slow.next;
                fast = fast.next;
            }
            fast.next = null;
        }

    }

    static class Node {
        int key;
        Node next;

        public Node(int pKey) {
            key = pKey;
            next = null;
        }
    }
}
