package src.main.java.array;

/**
 * @author warlock.deng
 * Created at 2019/9/8
 */
public class Array<T> {
    private T[] data;

    private int size;

    public Array() {
        this(10);
    }

    public Array(int capacity) {
        data = (T[]) new Object[capacity];
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int getCapacity() {
        return data.length;
    }

    public void addLast(T t) {
        add(size, t);
    }

    public void addFirst(T t) {
        add(0, t);
    }

    public void add(int index, T t) {
        if (index > size || index < 0) {
            throw new IllegalArgumentException("index out off size");
        }
        if (data.length == size) {
            resize(data.length << 1);
        }
//            for (int i = size - 1; i >= index; i--) {
//                data[i + 1] = data[i];
//            }
        if (size - index >= 0) {
            System.arraycopy(data, index, data, index + 1, size - index);
        }
        data[index] = t;
        size++;
    }

    public T get(int index) {
        check(index);
        return data[index];
    }

    public T getFirst() {
        return get(0);
    }

    public T getLast() {
        return get(size - 1);
    }

    public void set(int index, T t) {
        check(index);
        data[index] = t;
    }

    public boolean contains(T t) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(t)) {
                return true;
            }
        }
        return false;
    }

    public int find(T t) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(t)) {
                return i;
            }
        }
        return -1;
    }

    public T removeFirst() {
        return remove(0);
    }

    public T removeLast() {
        return remove(size - 1);
    }

    public T remove(int index) {
        check(index);
        T t = data[index];
//            for (int i = index + 1; i < size; i++) {
//                data[i - 1] = data[i];
//            }
        if (size - index + 1 >= 0) {
            System.arraycopy(data, index + 1, data, index, size - index + 1);
        }
        data[size] = null;
        size--;
        if (size == data.length >> 2) {
            resize(data.length >> 1);
        }
        return t;
    }

    public void removeElement(T t) {
        int index = find(t);
        if (index != -1) {
            remove(index);
        }
    }

    private void resize(int newCatacity) {
        T[] newData = (T[]) new Object[newCatacity];
//            for (int i = 0; i < size; i++) {
//                newData[i] = data[i];
//            }
        if (size > 0) {
            System.arraycopy(data, 0, newData, 0, size);
        }
        data = newData;
    }

    private void check(int index) {
        if (index > size || index < 0) {
            throw new IllegalArgumentException("index out off size");
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("size=");
        sb.append(size);
        sb.append(" catacity=");
        sb.append(data.length);
        sb.append(" arr is:[");
        for (int i = 0; i < size; i++) {
            sb.append(data[i]);
            if (i < size - 1) {
                sb.append(",");
            }
        }
        sb.append("]");
        return sb.toString();
    }

}

