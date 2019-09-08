package src.main.java.javaobject;

import java.util.*;

/**
 * @author Warlock.deng
 * Created at 2019-09-04
 */
public class ArrayDemo {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();

        LinkedList<Integer> linkedList = new LinkedList<>();

        Array array = new Array<Integer>();

        for (Integer i = 1; i < array.getCapacity(); i++) {
            array.addLast(i);
        }

        System.out.println(array.toString());

        array.addLast(30);
        System.out.println(array.toString());

        array.addLast(34);
        System.out.println(array.toString());

        array.removeFirst();
        System.out.println(array.toString());

    }

    private static void grow() {
        // overflow-conscious code
        int oldCapacity = 31;
        int newCapacity = oldCapacity + (oldCapacity >> 1);

        String a = String.valueOf(newCapacity);
    }


    public static class Array<T> {

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
            StringBuilder sb = new StringBuilder(data.length);
            sb.append("size=" + size);
            sb.append(" catacity=" + data.length);
            sb.append(" arr is:[");
            for (int i = 0; i < size; i++) {
                sb.append(data[i]);
                sb.append(",");
            }
            sb.append("]");
            return sb.toString();
        }


    }


}
