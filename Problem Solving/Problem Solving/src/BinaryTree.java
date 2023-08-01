
public class BinaryTree {

    private TreeNode root;

    private int size;


    void createTree() {
        root = null;
        size = 0;
    }

    void clearTree() {
        root = null;
        size = 0;
    }

    boolean isEmpty() {
        return root == null;
    }

    int size() {
        return size;
    }

    int depth() {
        return calcDepthRec(root);
    }

    void delete(int value) {
        root = deleteNode(root, value);
    }

    private TreeNode deleteNode(TreeNode current, int value) {
        if (current == null)
            return null;

        if (current.data == value) {
            if (current.left == null || current.right == null) {
                TreeNode temp = null;
                temp = current.left == null ? current.right : current.left;

                return temp;
            } else {
                TreeNode replacementNode = getSuccessor(current);
                current.data = replacementNode.data;
                current.right = deleteNode(current.right, current.data);

                return current;
            }
        }


        if (current.data < value) {
            current.right = deleteNode(current.right, value);
            return current;
        } else {
            current.left = deleteNode(current.left, value);
            return current;
        }

    }

    // getting min value of right
    // could be also by getting max of left
    private TreeNode getSuccessor(TreeNode current) {
        if (current == null)
            return null;

        TreeNode replacement = current.right;

        while (replacement.left != null)
            replacement = replacement.left;

        return replacement;
    }

    private int calcDepthRec(TreeNode tree) {
        if (tree == null)
            return 0;

        int a = calcDepthRec(tree.left);
        int b = calcDepthRec(tree.right);

        return (a > b) ? 1 + a : 1 + b;

    }

    void insert(int data) {
        root = insertInTree(root, data);
    }

    private TreeNode insertInTree(TreeNode current, int data) {
        if (current == null) {
            size++;
            return new TreeNode(data);
        }

        if (data > current.data) {
            current.right = insertInTree(current.right, data);
        } else if (data < current.data) {
            current.left = insertInTree(current.left, data);
        } else {
            return current;
        }

        return current;
    }


    boolean contains(int element) {
        return containsRec(element, root);
    }

    private boolean containsRec(int element, TreeNode base) {

        if (base == null)
            return false;

        if (base.data == element)
            return true;

        if (base.data > element) {
            return containsRec(element, base.left);
        } else {
            return containsRec(element, base.right);
        }
    }

    void traverseInPreOrder() {
        traverseInPreOrderRec(root);
    }

    private void traverseInPreOrderRec(TreeNode treeNode) {
        if (treeNode != null) {
            System.out.print(treeNode.data);
            traverseInPreOrderRec(treeNode.left);
            traverseInPreOrderRec(treeNode.right);
        }
    }

    void traverseInInOrderRec() {
        traverseInInOrderRec(root);
    }

    private void traverseInInOrderRec(TreeNode treeNode) {
        if (treeNode != null) {
            traverseInInOrderRec(treeNode.left);
            System.out.print(treeNode.data);
            traverseInInOrderRec(treeNode.right);
        }
    }

    void traverseInPostOrderRec() {
        traverseInPostOrderRec(root);
    }

    private void traverseInPostOrderRec(TreeNode treeNode) {
        if (treeNode != null) {
            traverseInPostOrderRec(treeNode.left);
            traverseInPostOrderRec(treeNode.right);
            System.out.print(treeNode.data);
        }
    }

    public boolean isBalancedBST() {
        int balanced = isBalancedBST(root);
        return (balanced >= 0);
    }

    private int isBalancedBST(TreeNode root) {
        if (root == null)
            return 0;

        int leftHeight = isBalancedBST(root.left);

        if (leftHeight == -1)
            return -1;

        int rightHeight = isBalancedBST(root.right);

        if (rightHeight == -1)
            return -1;

        if (Math.abs(leftHeight - rightHeight) > 1)
            return -1;
        else
            return Math.max(leftHeight, rightHeight) + 1; // returning the max height and adding one to it, because it's in a new level
    }
}
