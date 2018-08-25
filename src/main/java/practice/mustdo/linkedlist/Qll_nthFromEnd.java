package practice.mustdo.linkedlist;

public class Qll_nthFromEnd {

    Node head;

    public static void main(String[] args) {
        Qll_nthFromEnd llist = new Qll_nthFromEnd();
        llist.push(20);
        llist.push(4);
        llist.push(15);
        llist.push(35);

        llist.printNthFromLast(2);
    }

    private void printNthFromLast(int pI) {

        if(head == null){
            return;
        }

        Node fast = head;
        Node slow = head;

        for (int i = 0; i < pI; i++) {
            if(fast == null){
                System.out.println("Not enough nodes in list");
                return;
            }
            fast = fast.next;
        }

        while (fast != null){
            fast = fast.next;
            slow = slow.next;
        }
        System.out.println(slow.key);
    }

    private void push(int pI) {
        Node temp = new Node(pI);
        temp.next = head;
        head = temp;
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
