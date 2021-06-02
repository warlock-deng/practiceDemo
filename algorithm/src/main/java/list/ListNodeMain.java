package list;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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

        //deleteNode(two, 2);

        ListNode three = new ListNode(3);
        three.next = new ListNode(7);
        three.next.next = new ListNode(7);
        three.next.next.next = new ListNode(3);

        //isPalindrome(three);
        add();
        String text = "";
    }

    private static void add() {
        ListNode one = new ListNode(9);
        one.next = new ListNode(3);
        one.next.next = new ListNode(4);
        one.next.next.next = new ListNode(6);

        ListNode two = new ListNode(3);
        two.next = new ListNode(4);
        two.next.next = new ListNode(4);
        two.next.next.next = new ListNode(4);

        ListNode result = addHead(one, two);
        String aaaa = "";
    }

    private static ListNode addHead(ListNode one, ListNode two) {
        ListNode result = new ListNode(1);
        int flag = 0;
        ListNode curr = result;
        while (one != null || two != null || flag > 0) {
            int res = flag;
            if (one != null) {
                res += one.value;
                one = one.next;
            }
            if (two != null) {
                res += two.value;
                two = two.next;
            }

            if (res > 9) {
                res -= 10;
                flag = 1;
            } else {
                flag = 0;
            }
            curr.next = new ListNode(res);
            curr = curr.next;
        }
        return result.next;
    }

    private static ListNode add(ListNode one, ListNode two) {
        Stack<Integer> oneStack = new Stack<>();
        Stack<Integer> twoStack = new Stack<>();
        while (one != null) {
            oneStack.add(one.value);
            one = one.next;
        }

        while (two != null) {
            twoStack.add(two.value);
            two = two.next;
        }

        ListNode result = new ListNode(-1);
        int flag = 0;
        while (!oneStack.empty() || !twoStack.empty() || flag != 0) {
            int res = flag;
            if (!oneStack.empty()) {
                res += oneStack.pop();
            }
            if (!twoStack.empty()) {
                res += twoStack.pop();
            }
            if (res > 9) {
                flag = 1;
                res -= 10;
            } else {
                flag = 0;
            }
            ListNode next = new ListNode(res);
            ListNode curr = result.next;
            result.next = next;
            next.next = curr;
        }

        return result.next;
    }

    /**
     * 判断链表是否是回环链表
     * <p>
     * 快慢指针+反转链表，然后判断
     *
     * @param head 链表头
     * @return boolean
     */
    private static boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode tem = reverseList(slow);
        while (tem != null) {
            if (tem.value != head.value) {
                return false;
            }
            tem = tem.next;
            head = head.next;
        }
        return true;
    }

    /***
     * 判断是否是回环链表；
     * 先将链表入到数组中，然后首发下标判断
     * @param head 链表
     * @return true/false
     */
    private static boolean isPalindromeArr(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        List<Integer> arr = new ArrayList<>();
        ListNode currentNode = head;
        while (currentNode != null) {
            arr.add(currentNode.value);
            currentNode = currentNode.next;
        }

        int begin = 0;
        int end = arr.size() - 1;
        while (begin < end) {
            if (!arr.get(begin).equals(arr.get(end))) {
                return false;
            }
            begin++;
            end--;
        }
        return true;
    }

    /**
     * 删除倒数第index个节点
     * 快慢指针法；
     *
     * @param root  根节点
     * @param index 删除的位置
     * @return 新链接头节点
     */
    private static ListNode deleteNode(ListNode root, int index) {
        int num = index + 1;
        ListNode slow = root;
        ListNode tem = root;
        for (int i = 0; i < num; i++) {
            tem = tem.next;
        }
        while (tem != null) {
            slow = slow.next;
            tem = tem.next;
        }
        ListNode delete = slow.next;
        slow.next = delete.next;
        return root;
    }

    /***
     * 反转链表
     * @param head  头节点
     * @return 新头节点
     */
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
