package javaobject.thread;


import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author Warlock.deng
 * Created at 2019-09-29
 */
public class ReadWriteLockDemo {

    private final ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();

    private final Lock readLock = reentrantReadWriteLock.readLock();

    private final Lock writeLock = reentrantReadWriteLock.writeLock();

    private static Map<String, Data> map = new TreeMap<>();

    public Data getData(String key) {
        readLock.lock();
        try {
            return map.get(key);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            readLock.unlock();
        }
        return null;
    }

    public Set<String> getAllKeys() {
        readLock.lock();
        try {
            return map.keySet();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            readLock.unlock();
        }
        return null;
    }

    public void put(String key, Data value) {
        writeLock.lock();
        try {
            map.put(key, value);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            writeLock.unlock();
        }
    }


    class Data {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    public static void main(String[] args) {

    }
}
