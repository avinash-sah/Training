package practice.mustdo.tree;

import javafx.util.Pair;

public class QTree5_LevelSpiral {

    private Node root;

    public static void main(String[] args) {
        QTree5_LevelSpiral tree = new QTree5_LevelSpiral();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(7);
        tree.root.left.right = new Node(6);
        tree.root.right.left = new Node(5);
        tree.root.right.right = new Node(4);
        System.out.println("Spiral order traversal of Binary Tree is ");
        tree.printSpiral(tree.root);
    }

    private void printSpiral(Node pRoot) {
        int h = height(pRoot);
        boolean flip = true;
        for (int i = 1; i <= h; i++) {
            levelOrder(pRoot, i, flip);
            flip = !flip;
        }
    }

    private void levelOrder(Node pRoot, int pI, boolean pFlip) {
        if(pRoot == null){
            return;
        }
        if(pI == 1){
            System.out.print(pRoot.data + " ");
        }else {
            if(pFlip){
                levelOrder(pRoot.right, pI -1, pFlip);
                levelOrder(pRoot.left, pI -1, pFlip);
            }else{
                levelOrder(pRoot.left, pI -1, pFlip);
                levelOrder(pRoot.right, pI -1, pFlip);
            }
        }
    }

    private int height(Node pRoot) {
        if (pRoot == null) {
            return 0;
        }
        int lHeight = height(pRoot.left);
        int rHeight = height(pRoot.right);

        if (lHeight > rHeight) {
            return lHeight + 1;
        } else {
            return rHeight + 1;
        }
    }

    static class Node {
        int data;
        Node left, right;

        public Node(int pData) {
            data = pData;
            left = right = null;
        }
    }
}
