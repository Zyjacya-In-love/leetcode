package lcof2077;

/**
 * 剑指 Offer II 077. 链表排序
 * https://leetcode-cn.com/problems/7WHec2/
 * @author xzq
 * @create 2022-03-08-10:00
 */
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode head2 = slow.next;
        slow.next = null;
        head = sortList(head);
        head2 = sortList(head2);
        ListNode dummy = new ListNode(-1);
        ListNode tmp = dummy;
        while (head != null && head2 != null) {
            if (head.val <= head2.val) {
                tmp.next = head;
                head = head.next;
            }
            else {
                tmp.next = head2;
                head2 = head2.next;
            }
            tmp = tmp.next;
        }
        if (head != null) tmp.next = head;
        else if (head2 != null) tmp.next = head2;
        return dummy.next;
    }
}
