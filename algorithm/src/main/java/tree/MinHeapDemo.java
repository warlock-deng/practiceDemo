package tree;

/**
 * 最小堆
 *
 * @author Warlock.deng
 * Created at 2019-09-18
 */
public class MinHeapDemo<E extends Comparable<E>> {

    private E[] data;

    private int size;

    private int capacity;

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public MinHeapDemo() {
        this(10);
    }

    public MinHeapDemo(int capacity) {
        this.capacity = capacity;
        data = (E[]) new Comparable[capacity];
    }

    private int getParent(int index) {
        return (index - 1) >> 1;
    }

    private int getLeft(int index) {
        return (index << 1) + 1;
    }

    private int getRight(int index) {
        return (index << 1) + 2;
    }


}
