package lcof2021;

/**
 * 剑指 Offer II 021. 删除链表的倒数第 n 个结点
 * https://leetcode-cn.com/problems/SLwz0R/
 * @author xzq
 * @create 2022-03-08-9:28
 */
//     * Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1, head);
        ListNode fast = dummy;
        for (int i = 0; i < n + 1; i++) {
            fast = fast.next;
        }
        ListNode slow = dummy;
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }
}
