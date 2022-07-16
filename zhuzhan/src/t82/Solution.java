package t82;

/**
 * 82. 删除排序链表中的重复元素 II
 * https://leetcode.cn/problems/remove-duplicates-from-sorted-list-ii/
 * @from nio7.16 提前批笔试 1
 * @author xzq
 * @create 2022-07-16-20:24
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
// 题目要求删除重复节点，重复节点不保留，只要不同的节点
// 用 pre 和 curr 两个指针来操作，
// 看 curr 和 curr.next 等不等，等就一直删，直到 curr 不等于这个重复的值，pre.next 指向当前这个 curr
//                             不等就留着，尝试下一个，把 pre 和 curr 都指向下一个节点
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode curr = head;
        while (curr != null && curr.next != null) {
            if (curr.val == curr.next.val) {
                int dup = curr.val;
                while (curr != null && curr.val == dup) {
                    curr = curr.next;
                }
                pre.next = curr;
            } else {
                pre = curr;
                curr = curr.next;
            }
        }
        return dummy.next;
    }
}
// 通过   0 ms	41.4 MB
