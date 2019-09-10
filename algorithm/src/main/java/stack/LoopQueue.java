package stack;


import java.util.Arrays;

/**
 * @author warlock.deng
 * Created at 2019/9/8
 */
public class LoopQueue<E> implements Queue<E> {

    private E[] data;

    private int front, tail;

    private int size;

    public LoopQueue() {
        this(10);
    }

    public LoopQueue(int capacity) {
        data = (E[]) new Object[capacity + 1];
    }

    public int getCapacity() {
        return data.length - 1;
    }

    @Override
    public void enqueue(E e) {
        if ((tail + 1) % data.length == front) {
            resize(getCapacity() << 1);
        }
        data[tail] = e;
        tail = (tail + 1) % data.length;
        size++;
    }

    @Override
    public E dequeue() {
        if (isEmpty()) {
            throw new IllegalArgumentException("query is empty");
        }
        E e = data[front];
        data[front] = null;
        front = (front + 1) % data.length;
        size--;
        if (size < getCapacity() >> 2 && getCapacity() >> 1 != 0) {
            resize(getCapacity() >> 1);
        }
        return e;
    }

    @Override
    public E getFront() {
        return data[front];
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return tail == front;
    }

    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity + 1];
        for (int i = 0; i < size; i++) {
            newData[i] = data[(front + i) % data.length];
        }
        data = newData;
        front = 0;
        tail = size;
    }

    @Override
    public String toString() {
        return "LoopQueue{" +
                "data=" + Arrays.toString(data) +
                ", front=" + front +
                ", tail=" + tail +
                ", size=" + size +
                '}';
    }
}
