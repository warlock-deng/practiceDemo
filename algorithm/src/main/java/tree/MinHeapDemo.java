package tree;

import java.util.Arrays;

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

    private static final int DEFAULT_MIN_CAPACITY = 10;

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public MinHeapDemo() {
        this(DEFAULT_MIN_CAPACITY);
    }

    public MinHeapDemo(int capacity) {
        this.capacity = capacity;
        data = (E[]) new Comparable[capacity];
    }

    private int getParent(int index) {
        if (index < 2) {
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

    /**
     * 容量要满时，进行扩容；当少于4分之1时，进行缩容
     */
    private void resize() {
        //容量够用，且当前容量为默认容量，则不需要进行扩容或缩容
        if (size < capacity && DEFAULT_MIN_CAPACITY == capacity) {
            return;
        }
        int newCapacity = 0;
        if (size == capacity) {
            //容量要超，则需要进行扩容
            newCapacity = capacity << 1;
            capacity = newCapacity;
            data = Arrays.copyOf(data, newCapacity);
        }
        if (capacity > DEFAULT_MIN_CAPACITY && (size << 2) < capacity) {
            //若容量大于默认最小容量,且小于当前4分之1时，，则需要进行缩容
            newCapacity = capacity >> 1;
            capacity = newCapacity;
            data = Arrays.copyOf(data, newCapacity);
        }
    }

    public void add(E e) {
        resize();
        data[size] = e;
        siftUp(size);
        size++;
    }

    public E findMin() {
        if (isEmpty()) {
            return null;
        }
        return data[0];
    }

    public E extractMin() {
        E e = data[0];
        data[0] = data[size - 1];
        data[size - 1] = null;
        size--;
        siftDown(0);
        resize();
        return e;
    }

    private void siftDown(int index) {
        if (index > size - 1) {
            return;
        }
        int leftIndex = getLeft(index);
        int rightIndex = getRight(index);
        if (leftIndex < size && rightIndex < size) {
            if (data[index].compareTo(data[leftIndex]) < 0 && data[index].compareTo(data[index]) < 0) {
                return;
            }
            if (data[leftIndex].compareTo(data[rightIndex]) > 0) {
                swap(index, rightIndex);
                siftDown(rightIndex);
            } else {
                swap(index, leftIndex);
                siftDown(leftIndex);
            }
            return;
        }
        if (leftIndex < size) {
            if (data[index].compareTo(data[leftIndex]) > 0) {
                swap(index, leftIndex);
            }
        }
        if (rightIndex < size) {
            if (data[index].compareTo(data[rightIndex]) > 0) {
                swap(index, rightIndex);
            }
        }
    }

    private void siftUp(int index) {
        if (index < 1) {
            return;
        }
        int parentIndex = getParent(index);
        if (data[parentIndex].compareTo(data[index]) > 0) {
            swap(parentIndex, index);
            siftUp(parentIndex);
        }
    }

    private void swap(int indexFirst, int indexSencond) {
        E e = data[indexFirst];
        data[indexFirst] = data[indexSencond];
        data[indexSencond] = e;
    }

    @Override
    public String toString() {
        return "MinHeapDemo{" +
                "data=" + Arrays.toString(data) +
                ", size=" + size +
                ", capacity=" + capacity +
                '}';
    }

    public static void main(String[] args) {
        Integer[] tg = {50, 12, 65, 56, 65, 18, 12, 21, 21, 10, 7, 24};
        MinHeapDemo<Integer> maxHeap = new MinHeapDemo<>();
        for (int i = 0; i < tg.length; i++) {
            maxHeap.add(tg[i]);
        }
        System.out.println(maxHeap);

        int size = maxHeap.getSize();
        for (int i = 0; i < size; i++) {
            System.out.println(maxHeap);
            Integer e = maxHeap.extractMin();
            System.out.println(e);
        }
    }
}
