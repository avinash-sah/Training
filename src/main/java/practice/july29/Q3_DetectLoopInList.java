package practice.july29;

public class Q3_DetectLoopInList {

    public static void main(String[] args) {
        Q3_DetectLoopInList temp = new Q3_DetectLoopInList();
        Q3_DetectLoopInList.LinkedList llist = temp.new LinkedList();
        llist.add(10);
        llist.add(4);
        llist.add(15);
        llist.add(20);
        //llist.add(50);
        llist.print(llist.head);

        llist.head.next.next.next.next = llist.head.next;
        llist.detectLoop();
        llist.print(llist.head);
        llist.detectLoop();
        llist.print(llist.head);
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

        void detectLoop() {
            Node slow = head;
            Node fast = head;
            while (slow != null && fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
                if (slow == fast) {
                    System.out.println("Loop found");
                    removeLoop(head, slow);
                    return;
                }
            }
            System.out.println("No loop found");
        }

        void removeLoop(Node pHead, Node pLoop) {
            while (pHead.next != pLoop.next) {
                pHead = pHead.next;
                pLoop = pLoop.next;
            }
            pLoop.next = null;
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
