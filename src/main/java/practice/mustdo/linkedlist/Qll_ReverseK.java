package practice.mustdo.linkedlist;

public class Qll_ReverseK {

    Node head;

    public static void main(String[] args) {
        Qll_ReverseK llist = new Qll_ReverseK();
         /* Constructed Linked List is 1->2->3->4->5->6->
           7->8->8->9->null */
        llist.push(9);
        llist.push(8);
        llist.push(7);
        llist.push(6);
        llist.push(5);
        llist.push(4);
        llist.push(3);
        llist.push(2);
        llist.push(1);

        System.out.println("Given Linked List");
        llist.printList();

        llist.head = llist.reverse(llist.head, 3);

        System.out.println("Reversed list");
        llist.printList();
    }

    private Node reverse(Node pHead, int pI) {
        Node prev = null;
        Node curr = pHead;
        Node next = null;
        int count = 0;

        while (count < pI && curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            count++;
        }

        if (next != null) {
            pHead.next = reverse(next, pI);
        }

        return prev;
    }

    private void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.key + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    private void push(int pI) {
        Node node = new Node(pI);
        node.next = head;
        head = node;
    }

    class Node {
        int key;
        Node next;

        public Node(int pKey) {
            key = pKey;
            next = null;
        }
    }
}
