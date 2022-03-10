package t589;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xzq
 * @create 2022-03-10-22:34
 */
/*
// Definition for a Node.
*/
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};

class Solution {
    private List<Integer> res;
    public List<Integer> preorder(Node root) {
        res = new ArrayList<>();
        dfs(root);
        return res;
    }
    private void dfs(Node root) {
        if (root == null) {
            return;
        }
        res.add(root.val);
        for (Node child : root.children) {
            dfs(child);
        }
    }
}
