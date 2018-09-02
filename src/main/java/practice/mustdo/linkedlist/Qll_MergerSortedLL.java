package practice.mustdo.linkedlist;

import javafx.util.Pair;

public class Qll_MergerSortedLL {

    public static void main(String[] args) {
        Node head1 = new Node(1);
        head1.next = new Node(3);
        head1.next.next = new Node(5);

        // 1->3->5 LinkedList created

        Node head2 = new Node(0);
        head2.next = new Node(2);
        head2.next.next = new Node(4);

        // 0->2->4 LinkedList created

        Node mergedhead = merge(head1, head2);
        Node iMergeHead = merge_i(head1, head2);

        printList(mergedhead);
        printList(iMergeHead);
    }

    private static Node merge_i(Node pHead1, Node pHead2) {
        if(pHead1 == null) {
            return pHead2;
        }
        if(pHead2 == null){
            return pHead1;
        }

        if(pHead1.data < pHead2.data){
            return mergeUtil(pHead1, pHead2);
        }else {
            return mergeUtil(pHead2, pHead1);
        }
    }

    private static Node mergeUtil(Node pHead1, Node pHead2) {

        if(pHead1.next == null){
            pHead1.next = pHead2;
            return pHead1;
        }

        Node curr1 = pHead1;
        Node next1 = pHead1.next;
        Node curr2 = pHead2;
        Node next2 = pHead2.next;

        while (next1 != null && next2 != null){
            if(curr2.data > curr1.data && curr2.data < next1.data){

                next2 = curr2.next;
                curr1.next = curr2;
                curr2.next = next1;

                curr1 = curr2;
                curr2 = next2;

            }else{
                if(next1 != null){
                    curr1 = curr1.next;
                    next1 = next1.next;
                }else {
                    curr1.next = curr2;
                    return pHead1;
                }
            }
        }


        return pHead1;
    }

    private static Node merge(Node pHead1, Node pHead2) {
        if (pHead1 == null) {
            return pHead2;
        }
        if (pHead2 == null) {
            return pHead1;
        }
        if (pHead1.data < pHead2.data) {
            pHead1.next = merge(pHead1.next, pHead2);
            return pHead1;
        } else {
            pHead2.next = merge(pHead1, pHead2.next);
            return pHead2;
        }
    }

    private static void printList(Node pHead) {
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
