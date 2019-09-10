package stack;

/**
 * @author Warlock.deng
 * Created at 2019-09-09
 */
public class LinkedListStack<E> implements Stack<E> {

    private LinkedList<E> linkedList = new LinkedList<>();

    @Override
    public void push(E e) {
        linkedList.addFirst(e);
    }

    @Override
    public E pop() {
        return linkedList.removeFirst();
    }

    @Override
    public E peek() {
        return linkedList.getFirst();
    }

    @Override
    public int getSize() {
        return linkedList.getSize();
    }

    @Override
    public boolean isEmpty() {
        return linkedList.isEmpty();
    }
}
