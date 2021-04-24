package list;


import java.net.CacheRequest;

/**
 * 链表相关操作
 *
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
        two.next.next.next.next.next = new ListNode(15);

        //ListNode node = mergeListNode(one, two);
        ListNode res = reverseList(two);


        String text = "";
    }

    private static ListNode reverseList(ListNode head) {
        ListNode result = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode temp = result;
            result = curr;
            curr = curr.next;
            result.next = temp;

//            ListNode next = curr.next;
//            curr.next = prev;
//            prev = curr;
//            curr = next;
        }
        return result;
    }

    /**
     * 反转链表
     *
     * @param head
     * @return
     */
    private static ListNode reverseList1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    /**
     * 合并两个有序链表
     *
     * @param one 第一个链表
     * @param two 第二个链表
     * @return 合并后的链表
     */
    private static ListNode mergeListNode(ListNode one, ListNode two) {
        if (one == null) {
            return two;
        }
        if (two == null) {
            return one;
        }
        //虚拟头节点
        ListNode head = new ListNode(0);
        //动态指针
        ListNode tem = head;
        while (one != null || two != null) {
            if (one != null && two != null) {
                if (one.value > two.value) {
                    tem.next = two;
                    tem = tem.next;
                    two = two.next;
                } else {
                    tem.next = one;
                    tem = tem.next;
                    one = one.next;
                }
            } else {
                if (one != null) {
                    tem.next = one;
                    one = null;
                }
                if (two != null) {
                    tem.next = two;
                    two = null;
                }
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
