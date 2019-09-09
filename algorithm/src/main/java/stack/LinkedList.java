package src.main.java.stack;

/**
 * @author Warlock.deng
 * Created at 2019-09-09
 */
public class LinkedList<E> {

    private class Node {

        private E e;

        private Node next;

        public Node() {
            this(null, null);
        }

        public Node(E e) {
            this(e, null);
        }

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }
    }

    private Node dummyNode;

    private int size;

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public LinkedList() {
        this.dummyNode = new Node();
        this.size = 0;
    }

    public E getFirst() {
        return get(0);
    }

    public E getLast() {
        return get(size - 1);
    }

    public E get(int index) {
        check(index);

        Node preNode = dummyNode;
        for (int i = 0; i < index; i++) {
            preNode = preNode.next;
        }
        return preNode.e;
    }

    public void addFirst(E e) {
        add(0, e);
    }

    public void addLast(E e) {
        add(size, e);
    }

    public void add(int index, E e) {
        check(index);

        Node preNode = dummyNode;
        for (int i = 0; i < index; i++) {
            preNode = preNode.next;
        }

        Node curNode = new Node(e, preNode.next);
        preNode.next = curNode;
        size++;
    }

    public E removeFirst() {
        return remove(0);
    }

    public E removeLast() {
        return remove(size - 1);
    }

    public E remove(int index) {
        check(index);

        Node preNode = dummyNode;
        for (int i = 0; i < index; i++) {
            preNode = preNode.next;
        }

        Node curNode = preNode.next;
        preNode.next = curNode.next;
        curNode.next = null;
        size--;
        return curNode.e;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("LinkedList node [");
        Node preNode = dummyNode;
        for (int i = 0; i < size; i++) {
            preNode = preNode.next;
            stringBuilder.append(preNode.e);
            if (i < size - 1) {
                stringBuilder.append(",");
            }
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    private void check(int index) {
        if (size > 0 && (index > size - 1 || index < 0)) {
            throw new IllegalArgumentException("index is out off size");
        }

    }


    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();

        for (int i = 0; i < 10; i++) {
            linkedList.addFirst(i);
            System.out.println(linkedList);

            if (i % 3 == 2) {
                linkedList.removeLast();
                System.out.println(linkedList);
            }
        }

    }
}
