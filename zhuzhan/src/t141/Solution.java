package t141;

/**
 * 141. 环形链表
 * https://leetcode.cn/problems/linked-list-cycle/
 * @from leetcode top 145
 * @author xzq
 * @create 2022-07-18-19:40
 */
/*
 * Definition for singly-linked list.
 */
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}
// 快慢指针，快指针每次走两步，慢指针每次走一步，只要有环必然能相遇
// 如果没环，快指针必然先到 null
public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }
}
// 通过   0 ms	42.3 MB