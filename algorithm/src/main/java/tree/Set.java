package tree;

/**
 * @author warlock.deng
 * Created at 2019/9/11
 */
public interface Set<E> {

    void add(E e);

    void remove(E e);

    boolean contains(E e);

    int getSize();

    boolean isEmpty();
}
