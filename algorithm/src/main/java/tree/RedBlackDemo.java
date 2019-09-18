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






}
