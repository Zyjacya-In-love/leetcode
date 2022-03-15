package t2044;

/**
 * 2044. 统计按位或能得到最大值的子集数目
 * https://leetcode-cn.com/problems/count-number-of-maximum-bitwise-or-subsets/
 * @author xzq
 * @create 2022-03-15-23:05
 */
public class Solution {
    private int[] nums;
    private int maxVal = 0;
    private int cnt = 0;
    public int countMaxOrSubsets(int[] nums) {
        this.nums = nums;
        dfs(0, 0);
        return cnt;
    }
    private void dfs(int s, int orSum) {
        if (maxVal < orSum) {
            maxVal = orSum;
            cnt = 1;
        } else if (maxVal == orSum){
            cnt++;
        }
        for (int i = s; i < nums.length; i++) {
            dfs(i+1, orSum|nums[i]);
        }
    }
}