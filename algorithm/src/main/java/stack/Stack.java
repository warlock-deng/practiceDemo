package src.main.java.stack;

/**
 * @author warlock.deng
 * Created at 2019/9/8
 */
public interface Stack<E> {

    void push(E e);

    E pop();

    E peek();

    int getSize();

    boolean isEmpty();

}
