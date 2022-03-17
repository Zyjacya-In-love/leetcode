package lcof52;

/**
 * 剑指 Offer 52. 两个链表的第一个公共节点
 * https://leetcode-cn.com/problems/liang-ge-lian-biao-de-di-yi-ge-gong-gong-jie-dian-lcof/
 * @author xzq
 * @create 2022-03-17-9:29
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
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int aLen = 0, bLen = 0;
        ListNode aLast = headA, aTmp = headA;
        ListNode bLast = headB, bTmp = headB;
        while (aTmp != null) {
            aLast = aTmp;
            aTmp = aTmp.next;
            aLen++;
        }
        while (bTmp != null) {
            bLast = bTmp;
            bTmp = bTmp.next;
            bLen++;
        }
        if (aLast != bLast) return null;
        aTmp = headA;
        bTmp = headB;
        if (aLen > bLen) {
            for (int i = 0; i < aLen - bLen; i++) {
                aTmp = aTmp.next;
            }
        } else {
            for (int i = 0; i < bLen - aLen; i++) {
                bTmp = bTmp.next;
            }
        }
        while (aTmp != bTmp) {
            aTmp = aTmp.next;
            bTmp = bTmp.next;
        }
        return aTmp;
    }
}
