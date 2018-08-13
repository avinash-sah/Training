package practice.mustdo.tree;

public class QTree7_LCA {

    Node root;

    public static void main(String[] args) {
        QTree7_LCA tree = new QTree7_LCA();
        tree.root = new Node(20);
        tree.root.left = new Node(8);
        tree.root.right = new Node(22);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(12);
        tree.root.left.right.left = new Node(10);
        tree.root.left.right.right = new Node(14);

        int n1 = 10, n2 = 14;
        Node t = tree.lca(tree.root, n1, n2);
        Node s = tree.lca_i(tree.root, n1, n2);
        System.out.println("LCA of " + n1 + " and " + n2 + " is " + t.data);
        System.out.println("LCA of " + n1 + " and " + n2 + " is " + s.data);
    }

    private Node lca_i(Node pRoot, int pN1, int pN2) {

        while (pRoot != null){
            if(pRoot.data < pN1 && pRoot.data < pN2){
                pRoot = pRoot.right;
            }else if (pRoot.data > pN1 && pRoot.data > pN2){
                pRoot = pRoot.left;
            }else{
                break;
            }
        }
        return pRoot;
    }

    private Node lca(Node pRoot, int pN1, int pN2) {
        if (pRoot.data > pN1 && pRoot.data > pN2) {
            return lca(pRoot.left, pN1, pN2);
        } else if (pRoot.data < pN1 && pRoot.data < pN2) {
            return lca(pRoot.right, pN1, pN2);
        } else {
            return pRoot;
        }
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
