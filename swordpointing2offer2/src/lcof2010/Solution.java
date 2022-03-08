package lcof2010;

import java.util.HashMap;

/**
 * 剑指 Offer II 010. 和为 k 的子数组
 * https://leetcode-cn.com/problems/QTMn0o/
 * @author xzq
 * @create 2022-03-08-9:23
 */
public class Solution {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        int sum = 0;
        int ans = 0;
        HashMap<Integer, Integer> cnt = new HashMap<Integer, Integer>();
        cnt.put(0, 1);
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            ans += cnt.getOrDefault(sum-k, 0);
            cnt.put(sum, cnt.getOrDefault(sum, 0)+1);
        }
        return ans;
    }
}
