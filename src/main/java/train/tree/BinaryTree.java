package train.tree;

public class BinaryTree {
    private Node mRoot;

    public BinaryTree(){
        mRoot = null;
    }

    public BinaryTree(int pKey) {
        mRoot = new Node(pKey);
    }

    public void put(int pKey){
        if(mRoot == null) {
            mRoot = new Node(pKey);
        }else{

        }
    }
}
