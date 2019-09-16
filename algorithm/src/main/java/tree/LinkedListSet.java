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

    private int size;

    public LinkedListSet() {
        this.size = 0;
        head = null;
    }

    @Override
    public void add(E e) {
        if (contains(e)) {
            return;
        }
        if (isEmpty()) {
            head = new Node(e);
        } else {
            Node preNode = new Node(e);
            preNode.next = head;
            head = preNode;
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
            while (curr != null) {
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
        while (curr != null) {
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
        if (isEmpty()) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("LinkedListSet [");
        Node curr = head;
        while (curr != null) {
            stringBuilder.append(curr.e);
            if (curr.next != null) {
                stringBuilder.append(",");
            }
            curr = curr.next;
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }


    public static void main(String[] args) {
        Integer[] tg = {50, 12, 65, 56, 65, 18, 12, 21, 21, 10, 7, 24};
        LinkedListSet<Integer> linkedListSet = new LinkedListSet<>();
        for (int i = 0; i < tg.length; i++) {
            linkedListSet.add(tg[i]);
        }

        System.out.println(linkedListSet.toString());
    }
}
