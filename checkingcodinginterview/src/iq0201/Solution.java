package iq0201;

/**
 * 面试题 02.01. 移除重复节点
 * https://leetcode-cn.com/problems/remove-duplicate-node-lcci/
 * @author xzq
 * @create 2022-04-14-10:49
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
    public ListNode removeDuplicateNodes(ListNode head) {
        ListNode now = head;
        while (now != null) {
            ListNode tmp = now;
            while (tmp != null && tmp.next != null) {
                if (tmp.next.val == now.val) {
                    tmp.next = tmp.next.next;
                } else {
                    tmp = tmp.next;
                }
            }
            now = now.next;
        }
        return head;
    }
}