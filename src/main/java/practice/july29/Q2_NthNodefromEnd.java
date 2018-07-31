package practice.july29;

public class Q2_NthNodefromEnd {
    public static void main(String[] args) {
        Q2_NthNodefromEnd temp = new Q2_NthNodefromEnd();
        Q2_NthNodefromEnd.LinkedList llist = temp.new LinkedList();
        llist.add(20);
        llist.add(4);
        llist.add(15);
        llist.add(35);
        llist.print(llist.head);
        int key = llist.printN(llist.head, 2);
        System.out.println(key);
    }


    class LinkedList {
        Node head;

        LinkedList() {
            head = null;
        }

        void print(Node pNode) {
            while (pNode != null) {
                System.out.print(pNode.key + " ");
                pNode = pNode.next;
            }
            System.out.println();
        }

        void add(int key) {
            Node node = new Node(key);
            node.next = head;
            head = node;
        }


        int printN(Node pNode, int n) {
            if (pNode == null) {
                return -1;
            }
            Node curr = pNode;
            Node nCurr = pNode;
            int count = 0;
            while (count < n) {
                if (curr == null) {
                    return -1;
                }
                curr = curr.next;
                count++;
            }
            while (curr != null) {
                curr = curr.next;
                nCurr = nCurr.next;
            }

            return nCurr.key;
        }
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

