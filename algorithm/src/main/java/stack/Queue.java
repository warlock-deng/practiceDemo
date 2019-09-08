package src.main.java.stack;

/**
 * @author warlock.deng
 * Created at 2019/9/8
 */
public interface Queue<E> {

    void enqueue(E e);

    E dequeue();

    E getFront();

    int getSize();

    boolean isEmpty();

}
