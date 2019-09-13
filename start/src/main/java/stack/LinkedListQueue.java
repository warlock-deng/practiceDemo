package stack;

/**
 * 使用双向链表实现队列
 *
 * @author Warlock.deng
 * Created at 2019-09-09
 */
public class LinkedListQueue<E> implements Queue<E> {

    /**
     * 双向链表结构
     */
    private class Node {

        private E e;

        private Node next;

        private Node prev;

        public Node() {
            this(null, null, null);
        }

        public Node(E e) {
            this(e, null, null);
        }

        public Node(E e, Node next, Node prev) {
            this.e = e;
            this.next = next;
            this.prev = prev;
        }

    }

    private Node head;

    private Node tail;

    private int size;

    @Override
    public void enqueue(E e) {
        Node last = tail;
        Node newNode = new Node(e, null, last);
        tail = newNode;
        if (last == null) {
            head = newNode;
        } else {
            last.next = newNode;
        }
        size++;
    }

    @Override
    public E dequeue() {
        if (isEmpty()) {
            throw new IllegalArgumentException("linkedlist is empty");
        }
        Node first = head;
        E e = first.e;
        if (size == 1) {
            tail = null;
            head = null;
        } else {
            head = first.next;
            first.e = null;
            first.next = null;
        }
        size--;
        return e;
    }

    @Override
    public E getFront() {
        if (size == 1) {
            return head.e;
        }
        return tail.e;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("LinkedListQueue head [");
        if (size > 0) {
            Node prev = head;
            while (prev != null) {
                stringBuilder.append(prev.e);
                if (prev.next != null) {
                    stringBuilder.append(",");
                }
                prev = prev.next;
            }
        }
        stringBuilder.append("] tail");
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        Queue<Integer> linkedListQueue = new LinkedListQueue();
        for (int i = 0; i < 10; i++) {
            linkedListQueue.enqueue(i);
            System.out.println(linkedListQueue);

            if (i % 3 == 2) {
                int de = linkedListQueue.dequeue();
                System.out.println(de);
                System.out.println(linkedListQueue);
            }
        }
    }

}
