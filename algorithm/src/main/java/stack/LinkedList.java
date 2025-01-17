package stack;

/**
 * @author Warlock.deng
 * Created at 2019-09-09
 */
public class LinkedList<E> {

    private class ListNode {

        private E e;

        private ListNode next;

        public ListNode() {
            this(null, null);
        }

        public ListNode(E e) {
            this(e, null);
        }

        public ListNode(E e, ListNode next) {
            this.e = e;
            this.next = next;
        }
    }

    private ListNode dummyNode;

    private int size;

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public LinkedList() {
        this.dummyNode = new ListNode();
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

        ListNode preNode = dummyNode;
        for (int i = 0; i < index; i++) {
            preNode = preNode.next;
        }
        return preNode.e;
    }

    public ListNode getFirstNode() {
        return dummyNode.next;
    }

    public void addFirst(E e) {
        add(0, e);
    }

    public void addLast(E e) {
        add(size, e);
    }

    public void add(int index, E e) {
        check(index);

        ListNode preNode = dummyNode;
        for (int i = 0; i < index; i++) {
            preNode = preNode.next;
        }

        ListNode curNode = new ListNode(e, preNode.next);
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

        ListNode preNode = dummyNode;
        for (int i = 0; i < index; i++) {
            preNode = preNode.next;
        }

        ListNode curNode = preNode.next;
        preNode.next = curNode.next;
        curNode.next = null;
        size--;
        return curNode.e;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("LinkedList node [");
        ListNode preNode = dummyNode;
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

        for (int i = 0; i < 2; i++) {
            linkedList.addFirst(i);
            System.out.println(linkedList);

//            if (i % 3 == 2) {
//                linkedList.removeLast();
//                System.out.println(linkedList);
//            }
        }

        int n = 4;
        LinkedList.ListNode node = removeNode(linkedList.getFirstNode(), 2);

        System.out.println(linkedList);
        String assssssss = "";
    }

    /**
     * 快慢指针删除倒数第n个元素
     *
     * @param head 链头
     * @param n    n位
     * @return
     */
    private static LinkedList.ListNode removeNode(LinkedList.ListNode head, int n) {
        LinkedList.ListNode slow = head, fast = head;
        while (fast.next != null) {
            fast = fast.next;
            if (n == 0 ? true : n-- == 0) {
                slow = slow.next;
            }
        }
        if (n != 0) {
            return head;
        }
        fast.next = fast.next.next;
        return head;
    }

}
