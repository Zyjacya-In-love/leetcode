package lcof2080;

import java.util.ArrayList;
import java.util.List;

/**
 * 剑指 Offer II 080. 含有 k 个元素的组合
 * https://leetcode-cn.com/problems/uUsW3B/
 * @author xzq
 * @create 2022-03-08-9:59
 */
class Solution {
    List<List<Integer>> res;
    List<Integer> tmp;
    public void dfs(int s, int n, int k) {
        if (tmp.size() == k) {
            res.add(new ArrayList<>(tmp));
            return ;
        }
        for (int i = s; i <= n; i++) {
            tmp.add(i);
            dfs(i+1, n, k);
            tmp.remove(tmp.size()-1);
        }
    }
    public List<List<Integer>> combine(int n, int k) {
        res = new ArrayList<>();
        tmp = new ArrayList<>();
        dfs(1, n, k);
        return res;
    }
}
