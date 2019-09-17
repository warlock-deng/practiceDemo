package javaobject;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Warlock.deng
 * Created at 2019-09-04
 */
public class MapDemo {

    public static void main(String[] args) {
        Integer[] tg = {50, 12, 65, 8, 23, 69, 99, 56, 65, 18, 12, 21, 2, 10, 7, 24};

        HashMap hashMap = new HashMap<>(8);
        hashMap.put("","");

        TreeMap treeMap = new TreeMap();
        treeMap.put("","");

        Hashtable hashTable = new Hashtable();
        hashTable.put("", "");


        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        concurrentHashMap.put("", "");


        Set set = new HashSet<Integer>();


    }


}
