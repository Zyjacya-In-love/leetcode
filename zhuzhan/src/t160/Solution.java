package t160;

/**
 * @title 160. 相交链表
 * @link https://leetcode.cn/problems/intersection-of-two-linked-lists/
 * @from leetcode top 145
 * @author xzq
 * @create 2022-07-19-21:13
 */
/**
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
// 假设：A链表不相交部分长度为 a，B链表不相交部长度为 b，A B 链表相交部分长度为 c
// 那么，有 A链表 a+c+b = B链表 b+c+a
// 也就是说，pA 指针先在A上走一遍，结束后，再从 B上开始走，pB 指针现在B上走一遍，再从A开始走，
// 如果 pA pB 能指向相同指针，那么说明他们相交
// 否则 pA 走完一遍A又走一遍B之后仍没有相等，说明不相交
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode pA = headA;
        ListNode pB = headB;
        boolean flag = false;
        while (pA != pB) {
            pA = pA.next;
            if (pA == null) {
                if (flag) {
                    return null;
                }
                flag = true;
                pA = headB;
            }
            pB = pB.next;
            if (pB == null) {
                pB = headA;
            }
        }
        return pA;
    }
}
// 通过   1 ms	44.6 MB