package lcof2024;

/**
 * 剑指 Offer II 024. 反转链表
 * https://leetcode-cn.com/problems/UHnkqh/
 * @author xzq
 * @create 2022-03-08-9:31
 */
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode dummy = new ListNode(-1, head);
        ListNode curr = head.next;
        while (curr != null) {
            head.next = curr.next;
            curr.next = dummy.next;
            dummy.next = curr;
            curr = head.next;
        }
        return dummy.next;
    }
}
