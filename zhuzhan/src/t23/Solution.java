package t23;

import java.util.PriorityQueue;

/**
 * 23. 合并K个升序链表
 * https://leetcode.cn/problems/merge-k-sorted-lists/
 * @author xzq
 * @create 2022-07-09-18:29
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
//class Solution {
//    public ListNode mergeKLists(ListNode[] lists) {
//        PriorityQueue<PQNode> pq = new PriorityQueue<>((a1 , a2) -> Integer.compare(a1.node.val, a2.node.val));
//        for (int i = 0; i < lists.length; i++)  {
//            if (lists[i] != null) {
//                pq.offer(new PQNode(lists[i], i));
//                lists[i] = lists[i].next;
//            }
//        }
//        ListNode dummy = new ListNode();
//        ListNode pre = dummy;
//        while (!pq.isEmpty()) {
//            PQNode curr = pq.poll();
//            pre.next = curr.node;
//            pre = pre.next;
//            int idx = curr.from;
//            if (lists[idx] != null) {
//                pq.offer(new PQNode(lists[idx], idx));
//                lists[idx] = lists[idx].next;
//            }
//        }
//        return dummy.next;
//    }
//    class PQNode {
//        ListNode node;
//        int from;
//
//        public PQNode(ListNode node, int from) {
//            this.node = node;
//            this.from = from;
//        }
//    }
//}
// 通过   5 ms	42.8 MB


/*
 * @create 2022-08-18-14:29
 */
// 并不需要做一个 PQNode 存储当前节点来自哪个链表，因为当前节点的 next 就存储着 下一个节点，美团二面8.18
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a1 , a2) -> Integer.compare(a1.val, a2.val));
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null) {
                pq.offer(lists[i]);
            }
        }
        ListNode dummy = new ListNode();
        ListNode pre = dummy;
        while (!pq.isEmpty()) {
            ListNode curr = pq.poll();
            pre.next = curr;
            pre = pre.next;
            if (curr.next != null) {
                pq.offer(curr.next);
            }
        }
        return dummy.next;
    }
}
// 通过   4 ms	43.2 MB