package map;

/**
 * @author warlock.deng
 * Created at 2020/9/16
 */
public class BSTMap<K extends Comparable<K>, V> implements Map<K, V> {

    private class Node {

        private K key;

        private V value;

        private Node left, right;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

    }

    private int size;

    private Node root;

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }


    @Override
    public boolean contains(K key) {
        Node node = getNode(root, key);
        return node != null;
    }

    @Override
    public V get(K key) {
        Node node = getNode(root, key);
        return node == null ? null : node.value;
    }

    @Override
    public void set(K key, V value) {
        Node node = getNode(root, key);
        if (node == null) {
            throw new IllegalArgumentException(key + " dose not exists");
        }
        node.value = value;
    }

    @Override
    public V remove(K key) {



        return null;
    }

    @Override
    public void add(K key, V value) {
        root = add(root, key, value);
        size++;
    }

    private Node getNode(Node node, K key) {
        if (node == null) {
            return node;
        }
        if (key.compareTo(node.key) < 0) {
            return getNode(node.left, key);
        } else if (key.compareTo(node.key) > 0) {
            return getNode(node.right, key);
        } else {
            return node;
        }
    }

    private Node add(Node node, K key, V value) {
        if (node == null) {
            return new Node(key, value);
        }
        if (key.compareTo(node.key) < 0) {
            node = add(node.left, key, value);
        } else if (key.compareTo(node.key) > 0) {
            node = add(node.right, key, value);
        } else {
            node.value = value;
        }
        return node;
    }
}
