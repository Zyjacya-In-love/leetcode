package lcof37;

/**
 * 剑指 Offer 37. 序列化二叉树
 * https://leetcode-cn.com/problems/xu-lie-hua-er-cha-shu-lcof/
 * @author xzq
 * @create 2022-04-02-21:06
 */

import javax.management.QueryEval;
import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * Definition for a binary tree node.
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        StringBuilder res = new StringBuilder();
        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                TreeNode now = queue.poll();
                res.append(now == null ? "null" : now.val);
                res.append(",");
                if (now != null) {
                    queue.offer(now.left);
                    queue.offer(now.right);
                }
            }
        }
        res.deleteCharAt(res.length()-1);
        return res.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] splits = data.split(",");
        if (splits.length == 0 || splits[0].equals("null")) return null;
        Deque<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(splits[0]));
        queue.offer(root);
        int pos = 1;
        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = pos; i < Math.min(pos+2*len, splits.length); i+=2) {
                TreeNode now = queue.poll();
                now.left = splits[i].equals("null") ? null : new TreeNode(Integer.parseInt(splits[i]));
                now.right = splits[i+1].equals("null") ? null : new TreeNode(Integer.parseInt(splits[i+1]));
                if (now.left != null) queue.offer(now.left);
                if (now.right != null) queue.offer(now.right);
            }
            pos += 2*len;
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));