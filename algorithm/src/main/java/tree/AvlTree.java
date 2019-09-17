package tree;

/**
 * @author Warlock.deng
 * Created at 2019-09-17
 */
public class AvlTree<E extends Comparable<E>> {

    private class Node {

        private E e;

        private int height;

        private Node left;

        private Node right;

        public Node(E e) {
            this.e = e;
            height = 0;
            left = null;
            right = null;
        }

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
        if (root == null) {
            root = new Node(e);
            return root;
        }

        Node currNode = root;
        if (currNode.e.compareTo(e) < 0) {
        }
        return node;
    }


}
