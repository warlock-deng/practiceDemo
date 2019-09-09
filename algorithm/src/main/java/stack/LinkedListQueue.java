package src.main.java.stack;

/**
 * @author Warlock.deng
 * Created at 2019-09-09
 */
public class LinkedListQueue<E> implements Queue<E> {

    private LinkedList<E> linkedList = new LinkedList<>();

    @Override
    public void enqueue(E e) {

    }

    @Override
    public E dequeue() {
        return null;
    }

    @Override
    public E getFront() {
        return null;
    }

    @Override
    public int getSize() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }
}
