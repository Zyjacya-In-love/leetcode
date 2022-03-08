package lcof35;

import java.util.HashMap;

/**
 * 剑指 Offer 35. 复杂链表的复制
 * https://leetcode-cn.com/problems/fu-za-lian-biao-de-fu-zhi-lcof/
 * @author xzq
 * @create 2022-03-07-19:52
 */
/*
// Definition for a Node.
*/
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
class Solution {
    public Node copyRandomList(Node head) {
        HashMap<Node, Node> map = new HashMap<>();
        Node curr = head;
        while (curr != null) {
            map.putIfAbsent(curr, new Node(curr.val));
            if (curr.next != null) {
                map.putIfAbsent(curr.next, new Node(curr.next.val));
                map.get(curr).next = map.get(curr.next);
            }
            if (curr.random != null) {
                map.putIfAbsent(curr.random, new Node(curr.random.val));
                map.get(curr).random = map.get(curr.random);
            }
            curr = curr.next;
        }
        return map.get(head);
    }
}