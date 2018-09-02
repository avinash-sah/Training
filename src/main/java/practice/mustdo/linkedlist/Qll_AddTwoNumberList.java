package practice.mustdo.linkedlist;

public class Qll_AddTwoNumberList {

    private Node head1;
    private Node head2;

    public static void main(String[] args) {
        Qll_AddTwoNumberList list = new Qll_AddTwoNumberList();
        // creating first list
        list.head1 = new Node(7);
        list.head1.next = new Node(5);
        list.head1.next.next = new Node(9);
        list.head1.next.next.next = new Node(4);
        list.head1.next.next.next.next = new Node(6);
        System.out.print("First List is ");
        list.printList(list.head1);

        // creating seconnd list
        list.head2 = new Node(8);
        list.head2.next = new Node(4);
        System.out.print("Second List is ");
        list.printList(list.head2);

        // add the two lists and see the result
        Node rs = list.addTwoLists(list.head1, list.head2);
        System.out.print("Resultant List is ");
        list.printList(rs);
    }

    private Node addTwoLists(Node pHead1, Node pHead2) {
        Node result = null;
        Node prev = null;
        int carry = 0;
        int sum = 0;

        while (pHead1 != null || pHead2 != null) {

            sum = carry + (pHead1 != null ? pHead1.data : 0)
                    + (pHead2 != null ? pHead2.data : 0);

            carry = sum / 10;
            sum = sum % 10;

            Node temp = new Node(sum);
            if (result == null) {
                result = temp;
            } else {
                prev.next = temp;
            }
            prev = temp;

            if (pHead1 != null) {
                pHead1 = pHead1.next;
            }
            if (pHead2 != null) {
                pHead2 = pHead2.next;
            }
        }
        if(carry > 0){
            prev.next = new Node(carry);
        }
        return result;
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
