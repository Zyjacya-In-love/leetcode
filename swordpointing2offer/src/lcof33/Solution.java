package lcof33;

/**
 * 剑指 Offer 33. 二叉搜索树的后序遍历序列
 * https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-hou-xu-bian-li-xu-lie-lcof/
 * @author xzq
 * @create 2022-03-26-18:38
 */
class Solution {
    private int[] postorder;
    public boolean verifyPostorder(int[] postorder) {
        this.postorder = postorder;
        return dfs(0, postorder.length);
    }
    private boolean dfs(int s, int t) {
        if ((t-s) <= 3) return true;
        int root = t-1;
        int pos = root;
        while (pos >= s && postorder[pos] >= postorder[root]) pos--;
        for (int i = s; i <= pos; i++) {
            if (postorder[i] >= postorder[root]) {
                return false;
            }
        }
        return dfs(s, pos+1) && dfs(pos+1, t-1);
    }
}