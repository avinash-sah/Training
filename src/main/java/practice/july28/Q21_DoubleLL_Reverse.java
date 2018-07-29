package practice.july28;

import java.sql.SQLOutput;

public class Q21_DoubleLL_Reverse {

    Node head;

    public static void main(String[] args) {
        Q21_DoubleLL_Reverse list = new Q21_DoubleLL_Reverse();
        list.push(2);
        list.push(4);
        list.push(8);
        list.push(10);

        System.out.println("Original linked list ");
        list.printList(list.head);
        System.out.println();
        list.reverse();
        System.out.println("");
        System.out.println("The reversed Linked List is ");
        list.printList(list.head);
    }

    void reverse(){

        Node temp = null;
        Node curr = head;
        System.out.println("Reversing now");
        while (curr != null){
            //System.out.println("********");
            printList(curr);
            temp = curr.prev;
            curr.prev = curr.next;
            curr.next = temp;
            curr = curr.prev;
            printList(temp);
            System.out.println("********");
        }

        if (temp != null){
            head = temp;
        }

    }

    void push(int pKey) {
        Node node = new Node(pKey);
        if (head == null) {
            head = node;
            return;
        }
        node.next = head;
        head.prev = node;
        head = node;
    }

    void printList(Node pNode) {
        while (pNode != null) {
            System.out.print(pNode.key + " ");
            pNode = pNode.next;
        }
        System.out.println();
    }

    static class Node {
        int key;
        Node prev;
        Node next;

        public Node(int pKey) {
            key = pKey;
            prev = null;
            next = null;
        }
    }

}
