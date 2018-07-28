package practice.july25;

public class Q4_BST_SuccPre {

    Node root;

    public static void main(String[] args) {
        Q4_BST_SuccPre bstSuccPre = new Q4_BST_SuccPre();
        bstSuccPre.insert(50);
        bstSuccPre.insert(30);
        bstSuccPre.insert(20);
        bstSuccPre.insert(40);
        bstSuccPre.insert(70);
        bstSuccPre.insert(60);
        bstSuccPre.insert(80);
        bstSuccPre.printBST(bstSuccPre.root);
        Holder holder = new Holder();
        holder.pred = null;
        holder.succ = null;
        bstSuccPre.findSuccPred(bstSuccPre.root, holder, 65);
        System.out.println();
        if(holder.pred != null){
            System.out.println("prede " + holder.pred.key);
        }
        if(holder.succ != null){
            System.out.println("Succ " + holder.succ.key);
        }


    }

    void findSuccPred(Node pRoot, Holder pHolder, int key) {
        if (pRoot == null) {
            return;
        }
        if (pRoot.key == key) {
            if (pRoot.left != null) {
                Node temp = pRoot.left;
                while (temp.right != null) {
                    temp = temp.right;
                }
                pHolder.pred = temp;
            }

            if (pRoot.right != null) {
                Node temp = pRoot.right;
                while (temp.left != null) {
                    temp = temp.left;
                }
                pHolder.succ = temp;
            }
            return;
        }

        if (key > pRoot.key) {
            pHolder.pred = pRoot;
            findSuccPred(pRoot.right, pHolder, key);
        } else {
            pHolder.succ = pRoot;
            findSuccPred(pRoot.left, pHolder, key);
        }
    }

    void insert(int key) {
        root = insertNode(root, key);
    }

    private Node insertNode(Node pNode, int key) {
        if (pNode == null) {
            pNode = new Node(key);
            return pNode;
        }
        if (key > pNode.key) {
            pNode.right = insertNode(pNode.right, key);
        } else {
            pNode.left = insertNode(pNode.left, key);
        }
        return pNode;
    }

    void printBST(Node pNode) {
        if (pNode == null) {
            return;
        }
        printBST(pNode.left);
        System.out.print(pNode.key + " ");
        printBST(pNode.right);
    }

    static class Holder {
        Node succ;
        Node pred;
    }

    static class Node {
        int key;
        Node left;
        Node right;

        public Node(int pKey) {
            key = pKey;
            left = right = null;
        }
    }
}
