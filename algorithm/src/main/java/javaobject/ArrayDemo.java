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

grow();
    }

    private static void grow(){
        // overflow-conscious code
        int oldCapacity = 31;
        int newCapacity = oldCapacity + (oldCapacity >> 1);

        String a = String.valueOf(newCapacity);
    }


    public class Array<T> {

        private T[] data;

        private int size;

        public Array() {
            data = (T[]) new Objects[10];
        }

        public Array(int capacity) {
            data = (T[]) new Objects[capacity];
        }



    }


}
