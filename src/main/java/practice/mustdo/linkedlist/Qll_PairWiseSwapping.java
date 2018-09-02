package practice.mustdo.linkedlist;

public class Qll_PairWiseSwapping {

    private Node head;

    public static void main(String[] args) {
        Qll_PairWiseSwapping list = new Qll_PairWiseSwapping();
        list.head = new Node(1);
        list.head.next = new Node(2);
        list.head.next.next = new Node(3);
        list.head.next.next.next = new Node(4);
        list.head.next.next.next.next = new Node(5);
        list.head.next.next.next.next.next = new Node(6);
        list.head.next.next.next.next.next.next = new Node(7);

        System.out.println("Linked list before calling pairwiseSwap() ");
        list.printList(list.head);
        //Node st = list.pairWiseSwap(list.head);
        Node st = list.pairWiseSwap_i(list.head);
        System.out.println("");
        System.out.println("Linked list after calling pairwiseSwap() ");
        list.printList(st);
        System.out.println();
    }

    private Node pairWiseSwap(Node pHead) {
        if(pHead == null || pHead.next == null){
            return pHead;
        }
        Node remaining = pHead.next.next;
        Node newHead = pHead.next;
        newHead.next = pHead;
        pHead.next = pairWiseSwap(remaining);
        return newHead;
    }

    private Node pairWiseSwap_i(Node pHead){
        if(pHead == null || pHead.next == null){
            return pHead;
        }
        Node prev = pHead;
        Node curr = pHead.next;
        pHead = curr;

        while (true){
            Node next = curr.next;
            curr.next = prev;
            if(next == null || next.next == null){
                prev.next = next;
                break;
            }
            prev.next = next.next;
            prev = next;
            curr = prev.next;
        }

        return  pHead;
    }

    private void printList(Node pHead) {
        while (pHead != null) {
            System.out.print(pHead.data + " ");
            pHead = pHead.next;
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
