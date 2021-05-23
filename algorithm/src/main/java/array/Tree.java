package array;

public class Tree {

    public static void main(String[] args) {

        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);
        node.right.left = new TreeNode(4);

        printLeft(node, true);
    }

    public static void printLeft(TreeNode root, boolean left) {
        if (root == null) {
            return;
        }

        if (left) {
            System.out.println(root.val);
        }
        printLeft(root.left, true);
        printLeft(root.right, false);

    }

    public static void res(TreeNode root) {

        if (root == null) {
            return;
        }
        System.out.println(root.val);
        res(root.left);
        res(root.right);
    }


    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }


}
