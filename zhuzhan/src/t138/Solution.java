package t138;

import java.util.HashMap;
import java.util.HashSet;

/**
 * 138. 复制带随机指针的链表
 * 138. 复制带随机指针的链表
 * @from leetcode top 145
 * @author xzq
 * @create 2022-07-17-23:17
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
// 为解决随机指针的指向不确定，使用 HashMap 记录 原来节点 和 新深拷贝节点的映射，这样就可以通过 原来的节点获取 拷贝的节点了
// 什么时候赋值随机指针
//      ① 遍历一遍拷贝完所有节点，节点都放入 HashMap 之后，再遍历一遍赋值随即指针
//      ② 遍历的同时，在拷贝完一个节点的时候，新建这个节点随机指针，并放入 HashMap 防止重复新建相同节点
// 这里选择第 ② 种赋值时机
class Solution {
    public Node copyRandomList(Node head) {
        HashMap<Node, Node> copyMap = new HashMap<>();
        Node dummy = new Node(-1);
        Node pre = dummy;
        Node curr = head;
        while (curr != null) {
            Node tmp = getNode(curr, copyMap);
            if (curr.random != null) {
                tmp.random = getNode(curr.random, copyMap);
            }
            pre.next = tmp;
            pre = pre.next;
            curr = curr.next;
        }
        return dummy.next;
    }

    // 抽离重复逻辑
    private Node getNode(Node curr, HashMap<Node, Node> copyMap) {
        Node res;
        if (copyMap.containsKey(curr)) {
            res = copyMap.get(curr);
        } else {
            res = new Node(curr.val);
            copyMap.put(curr, res);
        }
        return res;
    }
}
// 通过   0 ms	41.2 MB