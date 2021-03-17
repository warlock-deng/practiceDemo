package map;


/**
 * @author warlock.deng
 * Created at 2020/9/16
 */
public class LinkListMap<K, V> implements Map<K, V> {

    private class Node {
        private K key;

        private V value;

        private Node next;
    }

    @Override
    public V remove(K key) {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(K key) {
        return false;
    }

    @Override
    public V get(K key) {
        return null;
    }

    @Override
    public void add(K key, V value) {

    }

    @Override
    public void set(K key, V value) {

    }
}
