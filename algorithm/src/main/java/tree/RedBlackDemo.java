package tree;

/**
 * @author Warlock.deng
 * Created at 2019-09-05
 */
public class RedBlackDemo<E> {

    private static final boolean RED = true;

    private static final boolean BLACK = false;

    private class Node {

        private E e;

        private Node left, right;

        private boolean color;

        public Node(E e) {
            this.e = e;
            color = BLACK;
            left = right = null;
        }

    }

    private void flipColor(Node node) {
        node.color = RED;
        node.left.color = BLACK;
        node.right.color = BLACK;
    }

    private Node leftRotate(Node node) {
        Node x = node.right;
        node.right = x.left;
        x.left = node;
        node.color = RED;
        return x;
    }

    private Node rightRotate(Node node) {
        Node x = node.left;
        node.left = x.right;
        x.right = node;
        x.color = node.color;
        node.color = RED;
        return x;
    }


}
