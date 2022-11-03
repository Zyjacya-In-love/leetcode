package t486;

/**
 * @title 486. 预测赢家
 * @link https://leetcode.cn/problems/predict-the-winner/
 * @from nongyan11.3
 * @author xzq
 * @create 2022-11-03-11:50
 */
// 定义：dp[i][j] 表示 在 nums[i:j] 中选择，相当于当前选择的人先选，最多能高于另一个人多少分，高于的分数为负数则说明必败，不可能高于另一个人
// 状态转移方程：可以从两个状态转移到 [i:j]，
//                  1. 当前选择 nums[i] 从 [i+1,j] 转移到 [i:j]
//                  2. 当前选择 nums[j] 从 [i,j-1] 转移到 [i:j]
//              在这两种可能里选最大的，即最多能高于另一个人多少分，对于具体的公式
//                  比如说对于 1. dp[i+1][j] 是 在 nums[i+1:j] 中选择，另一个人高于当前人 dp[i+1][j] 分，
//                  那么现在选择了 nums[i]，当前人将高于另一个人 nums[i]-dp[i+1][j] 分
//              因此 dp[i][j] = max(nums[i]-dp[i+1][j], nums[j]-dp[i][j-1])
// 初始化：至少有两个元素这个公式才能合理成立，所以 dp[i][i] 需要初始化，只有一个元素时当前选择的人必胜，胜 nums[i] 分，即 dp[i][i] = nums[i]
// 遍历顺序：dp[i][j] 依赖于 下面的dp[i+1][j] 和 左面的dp[i][j-1]，所以是自下向上，从左到右
class Solution {
    public boolean PredictTheWinner(int[] nums) {
        int n = nums.length;
        if ((n&1)==0) {
            return true;
        }
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = nums[i];
        }
        for (int i = n-1; i >= 0; i--) {
            for (int j = i+1; j < n; j++) {
                dp[i][j] = Math.max(nums[i]-dp[i+1][j], nums[j]-dp[i][j-1]);
            }
        }
        return dp[0][n-1] >= 0;
    }
}
