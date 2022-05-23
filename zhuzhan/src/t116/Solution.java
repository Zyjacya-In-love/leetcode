package t116;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 116. 填充每个节点的下一个右侧节点指针
 * https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node/
 * @author xzq
 * @create 2022-04-25-9:41
 */
/*
// Definition for a Node.
*/
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};

//class Solution {
//    public Node connect(Node root) {
//        Deque<Node> q = new LinkedList<>();
//        if (root != null) {
//            q.offer(root);
//        }
//        while (!q.isEmpty()) {
//            int len = q.size();
//            for (int i = 0; i < len; i++) {
//                Node now = q.poll();
//                if (i != len-1) {
//                    now.next = q.peek();
//                }
//                if (now.left != null) {
//                    q.offer(now.left);
//                }
//                if (now.right != null) {
//                    q.offer(now.right);
//                }
//            }
//        }
//        return root;
//    }
//}


/*
 * @create 2022-05-23-9:42
 */
//class Solution {
//    public Node connect(Node root) {
//        Deque<Node> queue = new LinkedList<>();
//        if (root != null) {
//            queue.offer(root);
//        }
//        Node preNode = new Node();
//        while (!queue.isEmpty()) {
//            int size = queue.size();
//            for (int i = 0; i < size; i++) {
//                Node curr = queue.poll();
//                if (i == 0) {
//                    preNode = curr;
//                } else {
//                    preNode.next = curr;
//                    preNode = curr;
//                }
//                if (curr.left != null) {
//                    queue.offer(curr.left);
//                }
//                if (curr.right != null) {
//                    queue.offer(curr.right);
//                }
//            }
//        }
//        return root;
//    }
//}
// 通过   2 ms	41.6 MB

//      法二：不使用 queue，利用上一层的 next 指针连成的链表，建立本层的 next，然后这么推下去，空间降为 O(1)
class Solution {
    public Node connect(Node root) {
        if (root == null) {
            return root;
        }
        Node leftMost = root;
        while (leftMost.left != null) {
            // leftMost.left == null 说明当前层是叶节点层，没有下一层了，无法用当前层的 next 建立下一层的的 next
            Node head = leftMost;
            while (head != null) {
                head.left.next = head.right;
                if (head.next != null) {
                    head.right.next = head.next.left;
                }
                head = head.next;
            }
            leftMost = leftMost.left;
        }
        return root;
    }
}
// 通过   0 ms	41.8 MB