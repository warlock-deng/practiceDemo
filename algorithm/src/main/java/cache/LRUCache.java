package cache;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 实现一个可自动删除非活跃key的缓存
 *
 * @author warlock.deng
 * Created at 2020/5/25
 */
public class LRUCache {

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);

        lruCache.put(1, 1);

        lruCache.put(2, 2);
        System.out.println(lruCache.get(1));

        lruCache.put(3, 3);


        LinkedHashMap map = new LinkedHashMap(2, 0.75f, true);
        map.getOrDefault("", -1);

        map.put("", 1);

        lruCache.get(2);

    }

    private Map<Integer, Node> data;

    private int capacity;

    /** 两个虚拟头尾节点，数据节点在中间 */
    private Node head = new Node(), tail = new Node();

    public LRUCache(int capacity) {
        this.capacity = capacity;
        data = new HashMap<>(capacity);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        Node result = data.get(key);
        if (result == null) {
            return -1;
        }
        moveToHead(result);
        return result.getValue();
    }

    public void put(int key, int value) {
        Node node = data.get(key);
        if (node == null) {
            node = new Node(key, value);
            data.put(key, node);
            moveToHead(node);
            if (data.size() > capacity) {
                removeTail();
            }
        } else {
            node.setValue(value);
            moveToHead(node);
        }
    }

    private void moveToHead(Node node) {
        //将node前后节点解绑
        removeNode(node);

        //将该节点添加到虚拟头节点后面
        Node next = head.next;
        head.next = node;
        node.prev = head;
        node.next = next;
        next.prev = node;
    }

    private void removeNode(Node node) {
        if (node.next == null || node.prev == null) {
            return;
        }
        node.prev.next = node.next;
        node.next.prev = node.prev;
        node.next = null;
        node.prev = null;
    }

    private void removeTail() {
        Node prev = tail.getPrev();
        removeNode(prev);
        data.remove(prev.getKey());
    }

    /**
     * 双向链表
     */
    class Node {
        private Integer key;

        private Integer value;

        private Node prev;

        private Node next;

        public Node() {
        }

        public Node(Integer key, Integer value) {
            this.key = key;
            this.value = value;
        }

        public Integer getKey() {
            return key;
        }

        public void setKey(Integer key) {
            this.key = key;
        }

        public Integer getValue() {
            return value;
        }

        public void setValue(Integer value) {
            this.value = value;
        }

        public Node getPrev() {
            return prev;
        }

        public void setPrev(Node prev) {
            this.prev = prev;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }


}
