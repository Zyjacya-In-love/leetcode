package lcof2079;

import java.util.ArrayList;
import java.util.List;

/**
 * 剑指 Offer II 079. 所有子集
 * https://leetcode-cn.com/problems/TVdhkn/
 * @author xzq
 * @create 2022-03-08-9:59
 */
class Solution {
    List<List<Integer>> ans;
    public void dfs(int[] nums, List<Integer> tmp, int s) {
        for (int i = s; i < nums.length; i++) {
            tmp.add(nums[i]);
            ans.add(new ArrayList<>(tmp));
            dfs(nums, tmp, i+1);
            tmp.remove(tmp.size()-1);
        }
    }
    public List<List<Integer>> subsets(int[] nums) {
        ans = new ArrayList<>();
        ans.add(new ArrayList<>());
        dfs(nums, new ArrayList<>(),0);
        return ans;
    }
}
