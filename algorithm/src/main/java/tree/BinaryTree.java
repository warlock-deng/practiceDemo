package tree;

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
        int[] nums = {6, 3, 8, 12, 2, 9, 45, 41, 67};
        for (int num : nums) {
            binaryTree.add(num);
        }

        // binaryTree.preOrder();

        System.out.println(binaryTree);
    }

}
