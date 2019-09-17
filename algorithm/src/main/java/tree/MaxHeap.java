package tree;


import java.util.Arrays;

/**
 * @author Warlock.deng
 * Created at 2019-09-16
 */
public class MaxHeap<E extends Comparable<E>> {

    private E[] data;

    private int size;

    private int capacity;

    public MaxHeap() {
        this(10);
    }

    public MaxHeap(int capacity) {
        data = (E[]) new Comparable[capacity];
        this.capacity = capacity;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private int getParent(int index) {
        if (index < 1) {
            return 0;
        }
        return (index - 1) >> 1;
    }

    private int getLeft(int index) {
        return (index << 1) + 1;
    }

    private int getRight(int index) {
        return (index << 1) + 2;
    }

    private void resize() {
        if (size < capacity) {
            return;
        }
        int newCapacity = capacity << 1;
        data = Arrays.copyOf(data, newCapacity);
//        E[] es = (E[]) new Object[newCapacity];
//        for (int i = 0; i < size; i++) {
//            es[i] = arr[i];
//        }
//        arr = es;
    }

    public void add(E e) {
        if (contains(e)) {
            return;
        }
        resize();
        data[size] = e;
        siftUp(size);
        size++;
    }

    public E findMax() {
        if (isEmpty()) {
            return null;
        }
        return data[0];
    }

    public E extractMax() {
        if (isEmpty()) {
            return null;
        }
        E e = data[0];
        data[0] = data[size - 1];
        data[size - 1] = null;
        size--;
        siftDown(0);
        return e;
    }

    private boolean contains(E t) {
        for (int i = 0; i < size; i++) {
            if (t.compareTo(data[i]) == 0) {
                return true;
            }
        }
        return false;
    }

    private void siftDown(int index) {
        if (index > size - 1) {
            return;
        }
        int leftIndex = getLeft(index);
        int rightIndex = getRight(index);
        if (leftIndex < size && rightIndex < size) {
            if (data[leftIndex].compareTo(data[rightIndex]) > 0) {
                swap(index, leftIndex);
                siftDown(leftIndex);
            } else {
                swap(index, rightIndex);
                siftDown(rightIndex);
            }
            return;
        }
        if (leftIndex < size) {
            if (data[index].compareTo(data[leftIndex]) < 0) {
                swap(index, leftIndex);
            }
        }
        if (rightIndex < size) {
            if (data[index].compareTo(data[rightIndex]) < 0) {
                swap(index, rightIndex);
            }
        }
    }

    private void siftUp(int index) {
        int parentIndex = getParent(index);
        if (parentIndex >= 0) {
            if (data[parentIndex].compareTo(data[index]) == 0) {
                return;
            }
            if (data[parentIndex].compareTo(data[index]) < 0) {
                swap(parentIndex, index);
                siftUp(parentIndex);
            }
        }
    }

    /**
     * 交换两个索引值
     *
     * @param index     index
     * @param swapIndex 交换的索引值
     */
    private void swap(int index, int swapIndex) {
        E curr = data[index];
        data[index] = data[swapIndex];
        data[swapIndex] = curr;
    }

    @Override
    public String toString() {
        return "MaxHeap{" +
                "arr=" + Arrays.toString(data) +
                ", size=" + size +
                ", capacity=" + capacity +
                '}';
    }

    public static void main(String[] args) {
        Integer[] tg = {50, 12, 65, 56, 65, 18, 12, 21, 21, 10, 7, 24};
        MaxHeap<Integer> maxHeap = new MaxHeap<>();
        for (int i = 0; i < tg.length; i++) {
            maxHeap.add(tg[i]);
        }
        System.out.println(maxHeap);

        int size = maxHeap.getSize();
        for (int i = 0; i < size; i++) {
            Integer e = maxHeap.extractMax();
            System.out.println(e);
            System.out.println(maxHeap);
        }
    }
}
