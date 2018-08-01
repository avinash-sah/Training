package practice.july29;

public class Q6_DLL_Deletion {
    Node head;

    public static void main(String[] args) {
        Q6_DLL_Deletion dll = new Q6_DLL_Deletion();
        dll.push(5);
        dll.push(2);
        dll.push(4);
        dll.push(8);
        dll.push(10);
        dll.printList(dll.head);

        dll.deleteAt(dll.head, 3);
        dll.printList(dll.head);
    }

    void printList(Node pHead) {
        while (pHead != null) {
            System.out.print(pHead.key + " ");
            pHead = pHead.next;
        }
        System.out.println();
    }

    boolean deleteKey(Node pHead, Node pNode) {

        if (pHead == null || pNode == null) {
            return false;
        }

        if (pNode == pHead) {
            head = pNode.next;
        }

        if (pNode.prev != null) {
            pNode.prev.next = pNode.next;
        }

        if (pNode.next != null) {
            pNode.next.prev = pNode.prev;
        }

        return true;
    }

    boolean deleteAt(Node pHead, int n) {
        if (pHead == null || n < 0) {
            return false;
        }
        int count = 0;
        while (count < n) {
            if (pHead == null) {
                return false;
            }
            pHead = pHead.next;
            count++;
        }
        return deleteKey(head, pHead);
    }

    void push(int key) {
        Node node = new Node(key);
        if (head == null) {
            head = node;
            return;
        }
        node.next = head;
        head.prev = node;
        head = node;

    }

    static class Node {
        Node prev;
        Node next;
        int key;

        public Node(int pKey) {
            key = pKey;
            prev = next = null;
        }
    }


}
