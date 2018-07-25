package train.tree;

public class Driver {
    public static void main(String[] args) {
        InsertionInTree tree = new InsertionInTree();
        tree.init();
        tree.inOrder(tree.getRoot());
        System.out.println();
        tree.insert(tree.getRoot(), 12);
        tree.inOrder(tree.getRoot());
        System.out.println();

        tree.delete(tree.getRoot(), 12);
        tree.inOrder(tree.getRoot());
        System.out.println("\n+++++++++");
        Traversal traversal = new Traversal();
        traversal.levelOrder(tree.getRoot());
        System.out.println();
        traversal.levelOrderPrint(tree.getRoot());
        System.out.println();
        traversal.inOrder(tree.getRoot());
        System.out.println();
        traversal.postOrder(tree.getRoot());
        System.out.println();
        traversal.preOrder(tree.getRoot());
        System.out.println();
    }
}
