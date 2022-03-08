package lcof2055;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 剑指 Offer II 055. 二叉搜索树迭代器
 * https://leetcode-cn.com/problems/kTOapQ/
 * @author xzq
 * @create 2022-03-08-9:49
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
class BSTIterator {
    private Deque<TreeNode> st;
    public BSTIterator(TreeNode root) {
        st = new LinkedList<>();
        TreeNode tmp = root;
        while (tmp != null) {
            st.push(tmp);
            tmp = tmp.left;
        }
    }

    public int next() {
        TreeNode now = st.pop();
        TreeNode tmp = now.right;
        while (tmp != null) {
            st.push(tmp);
            tmp = tmp.left;
        }
        return now.val;
    }

    public boolean hasNext() {
        return !st.isEmpty();
    }
}
