package t148;

/**
 * 148. 排序链表
 * https://leetcode.cn/problems/sort-list/
 * @from leetcode top 145
 * @author xzq
 * @create 2022-07-18-18:24
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
// 因为没有下标，只能归并排序
class Solution {
    public ListNode sortList(ListNode head) {
        return sortList(head, null);
    }

    private ListNode sortList(ListNode start, ListNode end) {
        if (start == end || start.next == end) {
            if (start != null) {
                start.next = null;
            }
            return start;
        }
        ListNode fast = start;
        ListNode slow = start;
        while (fast != end && fast.next != end) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode part1 = sortList(start, slow);
        ListNode part2 = sortList(slow, end);
        ListNode dummy = new ListNode();
        ListNode pre = dummy;
        while (part1 != null && part2 != null) {
            if (part1.val <= part2.val) {
                pre.next = part1;
                part1 = part1.next;
            } else {
                pre.next = part2;
                part2 = part2.next;
            }
            pre = pre.next;
        }
        if (part1 != null) {
            pre.next = part1;
        }
        if (part2 != null) {
            pre.next = part2;
        }
        return dummy.next;
    }
}
// 通过   9 ms	50 MB