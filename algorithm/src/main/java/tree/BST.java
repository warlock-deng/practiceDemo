package tree;

import java.util.ArrayList;

/**
 * @author warlock.deng
 * Created at 2020/9/11
 */
public class BST<E extends Comparable<E>> {

    public static void main(String[] args) {
        BST<Integer> bst = new BST<>();

        int[] arr = {12, 4, 5, 2, 98, 24, 34, 61, 6, 9};
        for (int i : arr) {
            bst.add(i);
        }

        String a = "";
    }

    private class Node {
        private E e;
        private Node left;
        private Node right;

        public Node(E e) {
            this.e = e;
            this.left = null;
            this.right = null;
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
        root = addNodeD(root, e);
//        if (root == null) {
//            root = new Node(e);
//        } else {
//            //addNodeFor(root, e);
//            addNode(root, e);
//        }
        size++;
    }

    private void addNodeFor(Node tem, E e) {
        for (; ; ) {
            if (e.compareTo(tem.e) < 0) {
                if (tem.left == null) {
                    tem.left = new Node(e);
                    break;
                }
                tem = tem.left;
                continue;
            }
            if (e.compareTo(tem.e) > 0) {
                if (tem.right == null) {
                    tem.right = new Node(e);
                    break;
                }
                tem = tem.right;
            }
        }
    }

    private void addNode(Node node, E e) {
        if (e.compareTo(node.e) < 0) {
            if (node.left == null) {
                node.left = new Node(e);
            } else {
                addNode(node.left, e);
            }
        }

        if (e.compareTo(node.e) > 0) {
            if (node.right == null) {
                node.right = new Node(e);
            } else {
                addNode(node.right, e);
            }
        }

    }

    private Node addNodeD(Node node, E e) {
        if (node == null) {
            return new Node(e);
        }
        if (e.compareTo(node.e) < 0) {
            node.left = addNodeD(node.left, e);
        } else if (e.compareTo(node.e) > 0) {
            node.right = addNodeD(node.right, e);
        }
        return node;
    }

    public boolean contains(E e) {
        return contains(root, e);
    }

    public Node removeMin(E e) {
        return null;
    }

    private boolean contains(Node node, E e) {
        if (node == null || e == null) {
            return false;
        }
        if (e.equals(node.e)) {
            return true;
        } else if (e.compareTo(node.e) < 0) {
            return contains(node.left, e);
        } else {
            return contains(node.right, e);
        }

    }


}
