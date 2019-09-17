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


    private Node head;

    private int size;





}
