package t117;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author xzq
 * @create 2022-05-23-10:03
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
//        Deque<Node> queue = new LinkedList<>();
//        if (root != null) {
//            queue.offer(root);
//        }
//        while (!queue.isEmpty()) {
//            int size = queue.size();
//            for (int i = 0; i < size; i++) {
//                Node curr = queue.poll();
//                if (i != size-1) {
//                    curr.next = queue.peek();
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
// 通过   2 ms	41 MB


//      法二：利用已经建立的上一层 next 组成的链表，建立下一层 的 next
class Solution {
    public Node connect(Node root) {
        Node leftMost = root;
        while (leftMost != null) {
            Node head = leftMost;
            leftMost = null;
            Node preNode = null;
            while (head != null) {
                if (head.left != null) {
                    if (preNode == null) {
                        preNode = head.left;
                        leftMost = preNode;
                    } else {
                        preNode.next = head.left;
                        preNode = preNode.next;
                    }
                }
                if (head.right != null) {
                    if (preNode == null) {
                        preNode = head.right;
                        leftMost = preNode;
                    } else {
                        preNode.next = head.right;
                        preNode = preNode.next;
                    }
                }
                head = head.next;
            }
        }
        return root;
    }
}
// 通过   0 ms	41.2 MB