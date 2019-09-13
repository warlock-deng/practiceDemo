package stack;

/**
 * @author warlock.deng
 * Created at 2019/9/11
 */
public class MergelistSlution {

    private static class ListNode {

        private int val;

        private ListNode next;

        public ListNode(int val) {
            this.val = val;
            this.next = null;
        }

        public ListNode(int[] nums) {
            if (nums == null) {
                throw new IllegalArgumentException("nums is null");
            }
            val = nums[0];
            for (int i = 1; i < nums.length; i++) {
                add(this, nums[i]);
            }
        }

        private void add(ListNode node, int num) {
            while (node.next != null) {
                node = node.next;
            }
            ListNode listNode = new ListNode(num);
            node.next = listNode;
        }

    }

    public static void main(String[] args) {

        int[] nums1 = {1, 4, 5};
        ListNode list1 = new ListNode(nums1);

        int[] nums2 = {1, 3, 4};
        ListNode list2 = new ListNode(nums2);

        int[] nums3 = {2, 6};
        ListNode list3 = new ListNode(nums3);

        ListNode[] listNodes = {list1, list2, list3};


        ListNode result = null;
        ListNode next = listNodes[0];
        ListNode curNode = null;
        while (next.next != null) {
            for (ListNode node : listNodes) {
                if (curNode == null) {
                    curNode = node;
                    continue;
                }

                if (node.val < curNode.val) {
                    curNode = node;
                }


            }
           
        }


        String a = "";
    }


}
