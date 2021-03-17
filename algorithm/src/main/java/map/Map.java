package map;

/**
 * @author warlock.deng
 * Created at 2020/9/16
 */
public interface Map<K, V> {

    int size();

    boolean isEmpty();

    boolean contains(K key);

    V get(K key);

    void add(K key, V value);

    void set(K key, V value);

    V remove(K key);
}
