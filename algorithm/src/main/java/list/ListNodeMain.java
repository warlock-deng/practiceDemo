package list;


/**
 * @author warlock.deng
 * Created at 2021/4/22
 */
public class ListNodeMain {

    public static void main(String[] args) {
        ListNode one = new ListNode(3);
        one.next = new ListNode(7);
        one.next.next = new ListNode(10);

        ListNode two = new ListNode(2);
        two.next = new ListNode(4);
        two.next.next = new ListNode(6);
        two.next.next.next = new ListNode(9);
        two.next.next.next.next = new ListNode(14);

        ListNode node = mergeListNode(one, two);

        String text = "";
    }

    private static ListNode mergeListNode(ListNode one, ListNode two) {
        ListNode head = new ListNode(0);
        if (one == null) {
            return two;
        }
        if (two == null) {
            return one;
        }
        ListNode tem = head;
        while (one != null || two != null) {
            if (one.value > two.value) {
                tem.next = two;
                tem = tem.next;
                two = two.next;
            } else {
                tem.next = one;
                tem = tem.next;
                one = one.next;
            }
        }

        return head.next;
    }


    private static class ListNode {

        public ListNode(int val) {
            this.value = val;
        }

        private ListNode prev;

        private ListNode next;

        private int value;

        public ListNode getPrev() {
            return prev;
        }

        public void setPrev(ListNode prev) {
            this.prev = prev;
        }

        public ListNode getNext() {
            return next;
        }

        public void setNext(ListNode next) {
            this.next = next;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }
    }

}
