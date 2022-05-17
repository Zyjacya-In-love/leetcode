package iq0207;

/**
 * 面试题 02.07. 链表相交
 * https://leetcode.cn/problems/intersection-of-two-linked-lists-lcci/
 * @author xzq
 * @create 2022-05-17-16:52
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
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode pA = headA;
        ListNode pB = headB;
        while (pA != pB) {
            // 判断 pA 和 pB 是不是等于，而不是 pA.next，这样pA才能等于null，要不咋判断 不相交啊？？？？
            pA = pA != null ? pA.next : headB;
            pB = pB != null ? pB.next : headA;
        }
        return pA;
    }
}
// 通过   1 ms	44.3 MB
