package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 翻转一棵二叉树
 *
 * @author warlock.deng
 * Created at 2021/4/27
 */
public class InvertTree {

    public static void main(String[] args) {
        Node root = new Node(4);
        root.left = new Node(2);
        root.right = new Node(7);

        root.left.left = new Node(1);
        root.left.right = new Node(3);

        root.right.left = new Node(6);
        root.right.right = new Node(9);

        //invert(root);

        levelOrder(root);

        String test = "";
    }

    private static void levelOrder(Node root) {
        Queue<Node> queue = new LinkedBlockingQueue<>();
        queue.add(root);
        List<List<Integer>> result = new ArrayList<>();

        boolean turn=false;
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            System.out.println(node.val);
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }

    }

    private static Node invert(Node root) {

        Node tem = root.left;
        root.left = root.right;
        root.right = tem;

        if (root.left != null) {
            invert(root.left);
        }
        if (root.right != null) {
            invert(root.right);
        }
        return root;
    }

    private static class Node {

        private Object val;

        private Node left;

        private Node right;

        public Node(Object val) {
            this.val = val;
        }

        public Object getVal() {
            return val;
        }

        public void setVal(Object val) {
            this.val = val;
        }

        public Node getLeft() {
            return left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node right) {
            this.right = right;
        }
    }
}
