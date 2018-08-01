package practice.july29;

public class Q4_QuickSortLL {
    Node head;

    public static void main(String[] args) {
        Q4_QuickSortLL ll = new Q4_QuickSortLL();
        ll.push(5);
        ll.push(20);
        ll.push(4);
        ll.push(3);
        ll.push(30);
        ll.printLL();
        ll.sort();
        ll.printLL();
    }

    void sort() {
        head = quickSort(head, tail(head));
    }

    private Node quickSort(Node pHead, Node pTail) {

        if (pHead == null || pHead == pTail) {
            return pHead;
        }

        Index index = new Index();
        index.end = null;
        index.start = null;
        Node pivot = partition(pHead, pTail, index);
        if (index.start != pivot) {
            Node temp = index.start;
            while (temp.next != pivot) {
                temp = temp.next;
            }
            temp.next = null;

            index.start = quickSort(index.start, temp);
            temp = tail(index.start);
            temp.next = pivot;
        }

        pivot.next = quickSort(pivot.next, index.end);
        return index.start;

    }

    private Node partition(Node pHead, Node pEnd, Index pIndex) {
        Node pivot = pEnd;
        Node curr = pHead;
        Node prev = null;
        Node tail = pivot;

        while (curr != pivot) {
            if (curr.data < pivot.data) {
                if (pIndex.start == null) {
                    pIndex.start = curr;
                }
                prev = curr;
                curr = curr.next;
            } else {
                // add curr to tail
                if (prev != null) {
                    prev.next = curr.next;
                }
                Node temp = curr.next;
                curr.next = null;
                tail.next = curr;
                tail = curr;
                curr = temp;
            }
        }

        if (pIndex.start == null) {
            pIndex.start = pivot;

        }
        pIndex.end = tail;
        return pivot;
    }

    private Node tail(Node pHead) {
        while (pHead != null && pHead.next != null) {
            pHead = pHead.next;
        }
        return pHead;
    }

    void push(int pData) {
        Node node = new Node(pData);
        node.next = head;
        head = node;
    }

    void printLL() {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
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

    static class Index {
        Node start;
        Node end;
    }
}
