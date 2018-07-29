package practice.july28;

public class Q18_InOrder_LevelOrder {

    Node head;

    public static void main(String[] args) {
        int in[] = {4, 8, 10, 12, 14, 20, 22};
        int level[] = {20, 8, 22, 4, 12, 10, 14};

        Q18_InOrder_LevelOrder tree = new Q18_InOrder_LevelOrder();
        tree.head = formTree();
    }

    private static Node formTree() {
        return null;
    }

    static class Node {
        int key;
        Node left, right;

        public Node(int pKey) {
            key = pKey;
            left = right = null;
        }
    }

}
