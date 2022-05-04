package t297;

import java.util.Collections;
import java.util.LinkedList;

/**
 * 297. 二叉树的序列化与反序列化
 * https://leetcode-cn.com/problems/serialize-and-deserialize-binary-tree/
 * @author xzq
 * @create 2022-05-02-16:35
 */
/*
 * Definition for a binary tree node.
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
public class Codec {

    private final String SEP = ",";
    private final String NULL = "#";

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        serialize(root, sb);
        return sb.toString();
    }

    private void serialize(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append(NULL).append(SEP);
            return;
        }
        sb.append(root.val).append(SEP);
        serialize(root.left, sb);
        serialize(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.isEmpty()) {
            return null;
        }
        LinkedList<String> nodes = new LinkedList<>();
        Collections.addAll(nodes, data.split(SEP));
        TreeNode root = deserialize(nodes);
        return root;
    }

    private TreeNode deserialize(LinkedList<String> nodes) {
        if (nodes.isEmpty()) {
            return null;
        }
        String cur = nodes.removeFirst();
        if (cur.equals(NULL)) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(cur));
        root.left = deserialize(nodes);
        root.right = deserialize(nodes);
        return root;
    }
}
// 通过   8 ms	43.3 MB

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
