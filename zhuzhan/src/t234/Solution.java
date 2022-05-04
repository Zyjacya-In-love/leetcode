package t234;


/**
 * 234. 回文链表
 * https://leetcode-cn.com/problems/palindrome-linked-list/
 * @author xzq
 * @create 2022-05-04-8:59
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
//    private ListNode left;
//    public boolean isPalindrome(ListNode head) {
//        left = head;
//        return dfs(head);
//    }
//
//    private boolean dfs(ListNode right) {
//        if (right == null) {
//            return true;
//        }
//        boolean flag = dfs(right.next);
//        flag = flag && (left.val == right.val);
//        left = left.next;
//        return flag;
//    }
//}
// 通过   15 ms	59.2 MB

// 迭代，空间复杂度O(1)，反转后半部分链表，推荐面试写
class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        if (fast != null) {
            slow = slow.next;
        }
        ListNode last = reverse(slow);
        ListNode left = head;
        ListNode right = last;
        boolean ans = true;
        while (right != null) {
            if (left.val != right.val) {
                ans = false;
                break;
            }
            left = left.next;
            right = right.next;
        }
        reverse(last);
        return ans;
    }

    private ListNode reverse(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
// 通过   4 ms	51.7 MB