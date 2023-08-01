public class TreeNode {
    int data;
    TreeNode left;

    TreeNode right;

    TreeNode(int data) {
        this.data = data;
    }

    TreeNode(int value, TreeNode left, TreeNode right) {
        data = value;
        this.right = right;
        this.left = left;
    }

    void setLeftNode(TreeNode right) {
        this.right = right;
    }

    void setRightNode(TreeNode right) {
        this.right = right;
    }


}
