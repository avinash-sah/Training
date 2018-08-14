package practice.mustdo.tree;

public class QTree10_CheckMirror {

    public static void main(String[] args) {
        Node a = new Node(1);
        Node b = new Node(1);
        a.left = new Node(2);
        a.right = new Node(3);
        a.left.left = new Node(4);
        a.left.right = new Node(5);

        b.left = new Node(3);
        b.right = new Node(2);
        b.right.left = new Node(4);
        b.right.right = new Node(5);

        boolean mirror = areMirror(a, b);
        System.out.println(mirror);
    }

    private static boolean areMirror(Node pA, Node pB) {
        if (pA == null && pB == null) {
            return true;
        }

        if (pA == null || pB == null) {
            return false;
        }

        if (pA.data == pB.data
                && areMirror(pA.left, pB.right)
                && areMirror(pA.right, pB.left)
        ) {
            return true;
        }

        return false;
    }

    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int pData) {
            data = pData;
            left = right = null;
        }
    }
}
