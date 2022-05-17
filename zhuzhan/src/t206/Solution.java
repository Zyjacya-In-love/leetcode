package t206;

/**
 * 206. 反转链表
 * https://leetcode-cn.com/problems/reverse-linked-list/
 * @author xzq
 * @create 2022-05-04-9:24
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
//    public ListNode reverseList(ListNode head) {
//        if (head == null || head.next == null) {
//            return head;
//        }
//        ListNode last = reverseList(head.next);
//        head.next.next = head;
//        head.next = null;
//        return last;
//    }
//}
// 通过   0 ms	41.3 MB

// 迭代，空间O(1)
//class Solution {
//    public ListNode reverseList(ListNode head) {
//        ListNode pre = null;
//        ListNode cur = head;
//        while (cur != null) {
//            ListNode next = cur.next;
//            cur.next = pre;
//            pre = cur;
//            cur = next;
//        }
//        return pre;
//    }
//}
// 通过   0 ms	41.4 MB

/*
 * @create 2022-05-17-16:19
 */
// 引入哑节点，然后不断的头插
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode dummy = new ListNode(-1, null);
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = dummy.next;
            dummy.next = curr;
            curr = next;
        }
        return dummy.next;
    }
}
// 通过   0 ms	41 MB