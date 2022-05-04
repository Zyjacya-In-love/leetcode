package t92;


/**
 * 92. 反转链表 II
 * https://leetcode-cn.com/problems/reverse-linked-list-ii/
 * @author xzq
 * @create 2022-05-04-9:30
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
// 递归
//class Solution {
//    public ListNode reverseBetween(ListNode head, int left, int right) {
//        if (left == 1) {
//            return reversePreN(head, right);
//        }
//        head.next = reverseBetween(head.next, left-1, right-1);
//        return head;
//    }
//    ListNode successor = null;
//    private ListNode reversePreN(ListNode head, int n) {
//        if (n == 1) {
//            successor = head.next;
//            return head;
//        }
//        ListNode last = reversePreN(head.next, n-1);
//        head.next.next = head;
//        head.next = successor;
//        return last;
//    }
//}
// 通过   0 ms	39 MB

// 迭代，空间O(1)
class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(-1, head);
        ListNode cur = dummy;
        for (int i = 0; i < left-1; i++) {
            cur = cur.next;
        }
        ListNode preLeft = cur;
        cur = cur.next;
        ListNode pre = null;
        for (int i = left; i <= right; i++) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        preLeft.next.next = cur;
        preLeft.next = pre;
        return dummy.next;
    }
}
// 通过   0 ms	39.4 MB