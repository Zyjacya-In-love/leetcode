package lcof2027;

/**
 * 剑指 Offer II 027. 回文链表
 * https://leetcode-cn.com/problems/aMhZSa/
 * @author xzq
 * @create 2022-03-08-9:33
 */
//     * Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode firstListEnd = halfOfList(head);
        ListNode secondListHead = reverseList(firstListEnd.next);
        ListNode p1 = head;
        ListNode p2 = secondListHead;
        boolean res = true;
        while (res && p2 != null) {
            if (p1.val != p2.val) {
                res = false;
            }
            p1 = p1.next;
            p2 = p2.next;
        }
        reverseList(secondListHead);
        return res;
    }
    public  ListNode halfOfList(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
        public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode dummy = new ListNode(-1, head);
        ListNode curr = head.next;
        while (curr != null) {
            head.next = curr.next;
            curr.next = dummy.next;
            dummy.next = curr;
            curr = head.next;
        }
        return dummy.next;
    }
}
