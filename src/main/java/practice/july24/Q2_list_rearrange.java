package practice.july24;

public class Q2_list_rearrange {

    static Node head;

    public static void main(String[] args) {
        Q2_list_rearrange list = new Q2_list_rearrange();
        list.head = new Node(1);
        list.head.next = new Node(2);
        list.head.next.next = new Node(3);
        list.head.next.next.next = new Node(4);
        list.head.next.next.next.next = new Node(5);

        list.printList(head); // print original list
        list.rearrange(head); // rearrange list as per ques
        list.printList(head); // print modified list
    }

    Node reverse(Node pHead) {
        Node prev = null;
        Node curr = pHead;
        Node next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    private void rearrange(Node pHead) {
        if(pHead == null){
            return;
        }

        //First find middle
       Node slow = pHead;
       Node fast = slow.next;
       while (fast != null && fast.next != null){
           slow = slow.next;
           fast = fast.next.next;
       }

       //split in middle
       Node node1 = pHead;
       Node node2 = slow.next;
       slow.next = null;
        // reverse the second half
       node2 = reverse(node2);
       //merge
        Node result = new Node(0);
        Node curr = result;
        while (node1 != null || node2 != null){
            if(node1 != null){
                curr.next = node1;
                curr = curr.next;
                node1 = node1.next;
            }
            if(node2 != null){
                curr.next = node2;
                curr = curr.next;
                node2 = node2.next;
            }
        }

        head = result.next;

    }

    void printList(Node pNode) {
        Node node = pNode;
        if (node == null) {
            return;
        }
        while (node != null) {
            System.out.print(node.key + " > ");
            node = node.next;
        }
        System.out.println();
    }

    static class Node {
        int key;
        Node next;

        Node(int pKey) {
            key = pKey;
            next = null;
        }
    }


}
