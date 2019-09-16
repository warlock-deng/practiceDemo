package tree;

/**
 * 基于单向链表的 集合实现
 *
 * @author Warlock.deng
 * Created at 2019-09-16
 */
public class LinkedListSet<E> implements Set<E> {

    private class Node {

        private E e;

        private Node next;

        public Node(E e) {
            this.e = e;
            next = null;
        }
    }

    private Node head;

    private Node last;

    private int size;

    @Override
    public void add(E e) {
        if (contains(e)) {
            return;
        }
        if (isEmpty()) {
            head = new Node(e);
        } else if (size == 1) {
            last = new Node(e);
            head.next = last;
        } else {
            Node preNode = new Node(e);
            preNode.next = last;
            last = preNode;
        }
        size++;
    }

    @Override
    public void remove(E e) {
        if (isEmpty()) {
            return;
        }
        Node pre = head;
        Node curr = head.next;
        if (pre.e.equals(e)) {
            head = pre.next;
            pre.next = null;

        } else if (curr.e.equals(e)) {
            head = curr.next;
            curr.next = null;
        } else {
            while (curr.next != null) {
                if (curr.e.equals(e)) {
                    break;
                }
                pre = pre.next;
                curr = curr.next;
            }
            pre.next = curr.next;
            curr.next = null;
        }
        size--;
    }

    @Override
    public boolean contains(E e) {
        if (isEmpty()) {
            return false;
        }
        Node curr = head;
        while (curr.next != null) {
            if (curr.e.equals(e)) {
                return true;
            }
            curr = curr.next;
        }
        return false;
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

        return stringBuilder.toString();
    }
}
