package train.tree;

import java.util.LinkedList;
import java.util.Queue;

public class InsertionInTree {

    private Node root;

    public void init() {
        root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right = new Node(3);
    }

    public Node getRoot() {
        return root;
    }

    public void inOrder(Node pNode) {
        if (pNode == null) {
            return;
        }
        inOrder(pNode.left);
        System.out.print(pNode.key + " ");
        inOrder(pNode.right);
    }

    public void insert(Node pNode, int pKey) {
        Queue<Node> nodeQueue = new LinkedList<>();
        nodeQueue.add(pNode);
        Node temp;
        while (!nodeQueue.isEmpty()) {
            temp = nodeQueue.remove();
            if (temp.left == null) {
                temp.left = new Node(pKey);
                break;
            } else {
                nodeQueue.add(temp.left);
            }

            if (temp.right == null) {
                temp.right = new Node(pKey);
                break;
            } else {
                nodeQueue.add(temp.right);
            }
        }
    }

    public void delete(Node pNode, int pKey) {
        Queue<Node> nodeQueue = new LinkedList<>();
        nodeQueue.add(pNode);

        Node keyNode = null;
        Node temp = null;

        while (!nodeQueue.isEmpty()) {
            temp = nodeQueue.remove();

            if (temp.key == pKey) {
                keyNode = temp;
            }
            if (temp.left != null) {
                nodeQueue.add(temp.left);
            }

            if (temp.right != null) {
                nodeQueue.add(temp.right);
            }
        }
        if (keyNode != null) {
            keyNode.key = temp.key;
            deleteNode(root, temp);
        }
    }

    private void deleteNode(Node pRoot, Node pTemp) {
        System.out.println(pTemp.key);
        Queue<Node> nodeQueue = new LinkedList<>();
        nodeQueue.add(pRoot);
        Node temp;

        while (!nodeQueue.isEmpty()) {
            temp = nodeQueue.remove();
            if (temp.right != null) {
                if (temp.right == pTemp) {
                    temp.right = null;
                    return;
                } else {
                    nodeQueue.add(temp.right);
                }
            }
            if (temp.left != null) {
                if (temp.left == pTemp) {
                    temp.left = null;
                    return;
                } else {
                    nodeQueue.add(temp.left);
                }
            }

        }
    }
}
