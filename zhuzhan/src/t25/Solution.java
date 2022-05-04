package t25;


import java.util.List;

/**
 * 25. K 个一组翻转链表
 * https://leetcode-cn.com/problems/reverse-nodes-in-k-group/
 * @author xzq
 * @create 2022-05-04-10:06
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
//    public ListNode reverseKGroup(ListNode head, int k) {
//        ListNode right = head;
//        for (int i = 0; i < k; i++) {
//            if (right == null) {
//                return head;
//            }
//            right = right.next;
//        }
//        ListNode newHead = reverse(head, right);
//        head.next = reverseKGroup(right, k);
//        return newHead;
//    }
//
//    private ListNode reverse(ListNode left, ListNode right) {
//        ListNode pre = right;
//        ListNode cur = left;
//        while (cur != right) {
//            ListNode next = cur.next;
//            cur.next = pre;
//            pre = cur;
//            cur = next;
//        }
//        return pre;
//    }
//}
// 通过   0 ms	40.8 MB

// 迭代
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(-1, head);
        ListNode pre = dummy;
        ListNode cur = pre.next;
        while (cur != null) {
            for (int i = 0; i < k; i++) {
                if (cur == null) {
                    return dummy.next;
                }
                cur = cur.next;
            }
            ListNode nextPre = pre.next;
            pre.next = reverse(pre.next, cur);
            pre = nextPre;
        }
        return dummy.next;
    }

    private ListNode reverse(ListNode left, ListNode right) {
        ListNode pre = right;
        ListNode cur = left;
        while (cur != right) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
// 通过   0 ms	41.2 MB