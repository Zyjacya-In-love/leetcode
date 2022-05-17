package t24;


/**
 * 24. 两两交换链表中的节点
 * https://leetcode.cn/problems/swap-nodes-in-pairs/
 * @author xzq
 * @create 2022-05-17-16:27
 */
/*
 * Definition for singly-linked list.
 */
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(-1, head);
        ListNode pre = dummy;
        ListNode curr = head;
        while (curr != null && curr.next != null) {
            ListNode next = curr.next;
            pre.next = next;
            curr.next = next.next;
            next.next = curr;
            pre = curr;
            curr = curr.next;
        }
        return dummy.next;
    }
}
// 通过   0 ms	39.4 MB
