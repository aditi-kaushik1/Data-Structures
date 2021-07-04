import com.codewithaditi.AVLNode;

public class AVLTree {
    AVLNode root;

    public void insert1(int val) {
        root = insert(root, val);
    }

    public AVLNode insert(AVLNode root, int val) {
        if(root == null)
            return new AVLNode(val);

        if(val < root.val)
            root.leftChild = insert(root.leftChild, val);
        if(val > root.val)
            root.rightChild = insert(root.rightChild, val);
        setHeight(root);

        return balance(root);
    }

    private AVLNode rotateLeft(AVLNode root) {
        AVLNode newRoot = root.rightChild;

        root.rightChild = newRoot.leftChild;
        newRoot.leftChild = root;
        setHeight(root);
        setHeight(newRoot);
        return newRoot;
    }

    private AVLNode rotateRight(AVLNode root) {
        AVLNode newRoot = root.leftChild;
        root.leftChild = newRoot.rightChild;
        newRoot.rightChild = root;

        setHeight(root);
        setHeight(newRoot);

        return newRoot;
    }

    private void setHeight(AVLNode root) {
        root.height = Math.max(height(root.leftChild), height(root.rightChild)) + 1;
    }

    private AVLNode balance(AVLNode root) {
        if(isLeftHeavy(root)) {
            if(balanceFactor(root.leftChild) < 0)
                root.leftChild = rotateLeft(root.leftChild);
            return rotateRight(root);
        }
        if(isRightHeavy(root)) {
            if(balanceFactor(root.rightChild) > 0)
                root.rightChild = rotateRight(root.rightChild);
            return rotateLeft(root);
        }
        //already balanced
        return root;
    }

    private int height(AVLNode root) {
        if(root == null)
            return -1;
        return root.height;
    }

    private boolean isLeftHeavy(AVLNode root) {
        return balanceFactor(root) > 1;
    }

    private boolean isRightHeavy(AVLNode root) {
        return balanceFactor(root) < -1;
    }

    private int balanceFactor(AVLNode root) {
        return (root == null) ? 0 : height(root.leftChild) - height((root.rightChild));
    }
}
