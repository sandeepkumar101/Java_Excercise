package Common;
public class RemoveDuplicatesfromSortedListII {
    public static void main(String[] args) {
        int[] nums = { 1, 1, 1, 2, 3, 3, 3, 4, 4, 5 };
        ListNode head = new ListNode(nums[0]);
        ListNode next = head;
        for (int i = 1; i < nums.length; i++) {
            ListNode cur = new ListNode(nums[i]);
            next.next = cur;
            next = cur;
        }
        ListNode res = deleteDuplicates(head);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }

    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static ListNode deleteDuplicates(ListNode head) {

        ListNode sentinel = new ListNode(0, head);
        
        ListNode prev = sentinel;
        ListNode cur = head;
        while(cur != null)
        {
            if(cur.next != null && cur.val == cur.next.val)
            {
                while(cur.next != null && cur.val == cur.next.val)
                {
                    cur = cur.next;
                }
                prev.next = cur.next;
            }
            else{
                prev = prev.next; // or cur
            }

            cur = cur.next;

        }
        
        return sentinel.next;
    }
}
