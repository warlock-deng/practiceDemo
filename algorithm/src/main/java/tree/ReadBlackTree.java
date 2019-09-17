package tree;


/**
 * 红黑树
 *
 * @author Warlock.deng
 * Created at 2019-09-17
 */
public class ReadBlackTree<K extends Comparable<K>, V> {
    private static final boolean RED = true;

    private static final boolean BLACK = false;

    private class Node {
        private K k;
        private V v;

        private boolean color;

        private Node left, right;

        public Node(K k, V v) {
            this.k = k;
            this.v = v;
            this.color = RED;
            left = right = null;
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

    public ReadBlackTree() {
        root = null;
        size = 0;
    }





}
