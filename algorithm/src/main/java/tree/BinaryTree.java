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
            this.e = e;
        }
    }




}
