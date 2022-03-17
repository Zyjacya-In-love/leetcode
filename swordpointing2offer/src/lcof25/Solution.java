package lcof25;

/**
 * 剑指 Offer 25. 合并两个排序的链表
 * https://leetcode-cn.com/problems/he-bing-liang-ge-pai-xu-de-lian-biao-lcof/
 * @author xzq
 * @create 2022-03-17-9:13
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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode tmp = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                tmp.next = l1;
                l1 = l1.next;
            } else {
                tmp.next = l2;
                l2 = l2.next;
            }
            tmp = tmp.next;
        }
        tmp.next = (l1 != null) ? l1 : l2;
        return dummy.next;
    }
}
