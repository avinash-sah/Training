package practice.mustdo.linkedlist;

public class Qll_MergeSortLL {

    private Node head;

    class Node{
        int data;
        Node next;

        public Node(int pData) {
            data = pData;
            next = null;
        }
    }

    private void push(int data){
        Node temp = new Node(data);
        temp.next = head;
        head = temp;
    }

    public static void main(String[] args) {
        Qll_MergeSortLL li = new Qll_MergeSortLL();
        li.push(15);
        li.push(10);
        li.push(5);
        li.push(20);
        li.push(3);
        li.push(2);
        System.out.println("Linked List without sorting is :");
        li.printList(li.head);

        // Apply merge Sort
        li.head = li.mergeSort(li.head);
        System.out.println("Sorted Linked List is: ");
        li.printList(li.head);
    }

    private Node mergeSort(Node pHead) {
        if(pHead == null || pHead.next == null){
            return pHead;
        }
        Node mid = getMiddle(pHead);
        Node midNext = mid.next;
        mid.next = null;

        Node left = mergeSort(pHead);
        Node right = mergeSort(midNext);
        return sortMerged(left, right);
    }

    private Node sortMerged(Node pLeft, Node pRight) {
        if(pRight == null){
            return pLeft;
        }
        if(pLeft == null){
            return pRight;
        }
        Node result = null;

        if(pLeft.data < pRight.data){
            result = pLeft;
            result.next = sortMerged(pLeft.next, pRight);
        }else{
            result = pRight;
            result.next = sortMerged(pLeft, pRight.next);
        }
        return result;
    }

    private Node getMiddle(Node pHead) {
        if(pHead == null){
            return null;
        }
        Node slow = pHead;
        Node fast = pHead.next;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private void printList(Node pHead) {
        while (pHead != null){
            System.out.print(pHead.data + " ");
            pHead = pHead.next;
        }
        System.out.println();
    }
}
