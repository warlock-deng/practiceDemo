package tree;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author warlock.deng
 * Created at 2019/9/10
 */
public class BinaryTree<E extends Comparable> {

    private class Node {

        private E e;

        private Node left;

        private Node right;

        public Node(E e) {
            left = null;
            right = null;
            this.e = e;
        }
    }

    public BinaryTree() {
        root = null;
        size = 0;
    }

    private Node root;

    private int size;

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(E e) {
        root = add(root, e);
    }

    private Node add(Node node, E e) {
        if (node == null) {
            node = new Node(e);
            size++;
            return node;
        }

        if (e.compareTo(node.e) < 0) {
            node.left = add(node.left, e);
        } else if (e.compareTo(node.e) > 0) {
            node.right = add(node.right, e);
        }
        return node;
    }

    public boolean contains(E e) {
        return contains(root, e);
    }

    private boolean contains(Node node, E e) {
        if (node == null) {
            return false;
        }

        if (e.compareTo(node.e) == 0) {
            return true;
        }

        if (e.compareTo(node.e) < 0) {
            return contains(node.left, e);
        } else {
            return contains(node.right, e);
        }
    }

    public void preOrder() {
        preOrder(root);
    }

    private void preOrder(Node node) {
//        if (node == null) {
//            return;
//        }

        if (node != null) {
            System.out.println(node.e);
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    public void preOrderNR() {
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node cur = stack.pop();
            System.out.println(cur.e);
            if (cur.right != null) {
                stack.push(cur.right);
            }
            if (cur.left != null) {
                stack.push(cur.left);
            }
        }
    }


    public void inOrder() {
        inOrder(root);
    }

    private void inOrder(Node node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        System.out.println(node.e);
        inOrder(node.right);
    }

    public void postOrder() {
        postOrder(root);
    }

    private void postOrder(Node node) {
        if (node == null) {
            return;
        }
        postOrder(node.left);
        postOrder(node.right);

        System.out.println(node.e);
    }

    public void levelOrder() {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node curNode = queue.poll();
            System.out.println(curNode.e);
            if (curNode.left != null) {
                queue.add(curNode.left);
            }
            if (curNode.right != null) {
                queue.add(curNode.right);
            }
        }
    }

    public E miniMum() {
        if (size == 0) {
            throw new IllegalArgumentException("is empty");
        }
        return miniMunNR(root).e;
    }

    private Node miniMun(Node node) {
        if (node.left == null) {
            return node;
        }
        return miniMun(node.left);
    }

    private Node miniMunNR(Node node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    public E maxNum() {
        if (isEmpty()) {
            throw new IllegalArgumentException("is empty");
        }
        return maxMum(root).e;
    }

    private Node maxMum(Node node) {
        if (node.right == null) {
            return node;
        }
        return maxMum(node.right);
    }

    public E removeMin() {
        E ret = miniMum();
        root = removeMin(root);
        return ret;
    }

    private Node removeMin(Node node) {
        if (node.left == null) {
            Node right = node.right;
            node.right = null;
            size--;
            return right;
        }

        node.left = removeMin(node.left);
        return node;
    }

    public E removeMax() {
        E result = maxNum();
        root = removeMax(root);
        return result;
    }

    private Node removeMax(Node node) {
        if (node.right == null) {
            Node left = node.left;
            node.left = null;
            return left;
        }
        node.right = removeMax(node.right);
        return node;
    }

    public void remove(E e) {
        root = removeNode(root, e);
    }

    public Node removeNode(Node node, E e) {
        if (node == null) {
            return null;
        }
        if (e.compareTo(node.e) > 0) {
            node.right = removeNode(node.right, e);
            return node;
        } else if (e.compareTo(node.e) < 0) {
            node.left = removeNode(node.left, e);
            return node;
        } else {
            if (node.left == null) {
                Node rights = node.right;
                node.right = null;
                size--;
                return rights;
            }
            if (node.right == null) {
                Node left = node.left;
                node.left = null;
                size--;
                return left;
            }

            Node successor = miniMun(node.right);
            successor.right = removeMin(node.right);
            successor.left = node.left;
            node.left = node.right = null;
            return successor;
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        generateToString(root, 0, builder);
        return builder.toString();
    }

    private void generateToString(Node node, int dept, StringBuilder builder) {
        if (node == null) {
            builder.append(generateDeptString(dept) + " null \n");
            return;
        }

        builder.append(generateDeptString(dept) + node.e + "\n");
        generateToString(node.left, dept + 1, builder);
        generateToString(node.right, dept + 1, builder);
    }

    private String generateDeptString(int dept) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < dept; i++) {
            builder.append("-");
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        BinaryTree<Integer> binaryTree = new BinaryTree<>();
        int[] nums = {5, 3, 6, 8, 4, 2,7};


        for (int num : nums) {
            binaryTree.add(num);
        }

//        for (int num : nums) {
//            System.out.println(binaryTree.removeMin());
//        }

        // binaryTree.remove(6);

        binaryTree.preOrder();

        System.out.println("************");
       binaryTree.preOrderNR();
//
        System.out.println("************");
        binaryTree.inOrder();
//
        System.out.println("************");
        binaryTree.postOrder();
        //System.out.println(binaryTree);
    }

}
