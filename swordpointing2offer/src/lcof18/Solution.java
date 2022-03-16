package lcof18;

/**
 * 剑指 Offer 18. 删除链表的节点
 * https://leetcode-cn.com/problems/shan-chu-lian-biao-de-jie-dian-lcof/
 * @author xzq
 * @create 2022-03-16-22:44
 */
/**
 * Definition for singly-linked list.
 */
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
class Solution {
    public ListNode deleteNode(ListNode head, int val) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode now = dummy.next;
        while (now != null) {
            if (now.val == val) {
                prev.next = now.next;
            } else {
                prev = prev.next;
            }
            now = now.next;
        }
        return dummy.next;
    }
}
