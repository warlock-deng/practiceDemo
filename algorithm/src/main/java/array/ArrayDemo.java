package src.main.java.array;

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


}
