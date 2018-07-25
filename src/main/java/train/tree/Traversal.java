package train.tree;

import java.util.LinkedList;
import java.util.Queue;

public class Traversal {

    public void levelOrder(Node pNode){
        Queue<Node> nodes = new LinkedList<>();
        nodes.add(pNode);
        Node temp;
        while (!nodes.isEmpty()){
            temp = nodes.remove();
            System.out.print(temp.key + " ");
            if(temp.left != null){
                nodes.add(temp.left);
            }
            if(temp.right != null){
                nodes.add(temp.right);
            }
        }
    }

    public void levelOrderPrint(Node pNode){
        int height = height(pNode);
        for (int i = 1; i <= height; i++) {
            printLevelOrder(pNode, i);
        }
    }

    private void printLevelOrder(Node pNode, int pLevel) {
        if(pNode == null){
            return;
        }
        if(pLevel == 1){
            System.out.print(pNode.key + " ");
        }else if(pLevel > 1){
            printLevelOrder(pNode.left, pLevel - 1);
            printLevelOrder(pNode.right, pLevel - 1);
        }

    }

    private int height(Node pNode) {
        if(pNode == null){
            return 0;
        }else {
            int lHeight = height(pNode.left);
            int rHeight = height(pNode.right);
            return lHeight > rHeight ? lHeight + 1: rHeight + 1;
        }

    }

    public void inOrder(Node pNode) {
        if (pNode == null) {
            return;
        }
        inOrder(pNode.left);
        System.out.print(pNode.key + " ");
        inOrder(pNode.right);
    }

    public void postOrder(Node pNode) {
        if (pNode == null) {
            return;
        }
        inOrder(pNode.left);
        inOrder(pNode.right);
        System.out.print(pNode.key + " ");
    }

    public void preOrder(Node pNode) {
        if (pNode == null) {
            return;
        }
        System.out.print(pNode.key + " ");
        inOrder(pNode.left);
        inOrder(pNode.right);
    }
}
