package t2;

/**
 * 2. 两数相加
 * https://leetcode.cn/problems/add-two-numbers/
 * @author xzq
 * @create 2022-07-08-22:10
 */
/**
 * Definition for singly-linked list.
 */
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
// 模拟加法操作，维护进位变量 carry
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode();
        ListNode pre = dummy;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int a = l1 == null ? 0 : l1.val;
            int b = l2 == null ? 0 : l2.val;
            int sum = a+b+carry;
            pre.next = new ListNode(sum%10);
            carry = sum/10;
            pre = pre.next;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (carry != 0) {
            pre.next = new ListNode(carry);
        }
        return dummy.next;
    }
}
// 通过   1 ms	41.8 MB
