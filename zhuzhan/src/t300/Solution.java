package t300;

import java.util.Arrays;

/**
 * 300. 最长递增子序列
 * https://leetcode-cn.com/problems/longest-increasing-subsequence/
 * @author xzq
 * @create 2022-03-28-21:01
 */
// O(n^2)
//class Solution {
//    public int lengthOfLIS(int[] nums) {
//        int n = nums.length;
//        int ans = 0;
//        int[] dp = new int[n];
//        for (int i = 0; i < n; i++) {
//            dp[i] = 1;
//            for (int j = i-1; j >= 0; j--) {
//                if (nums[i] > nums[j]) {
//                    dp[i] = Math.max(dp[i], dp[j]+1);
//                }
//            }
//            ans = Math.max(ans, dp[i]);
//        }
//        System.out.println(Arrays.toString(dp));
//        return ans;
//    }
//}
// O(nlogn) 贪心+二分
//class Solution {
//    public int lengthOfLIS(int[] nums) {
//        int n = nums.length;
//        if (n == 0) {
//            return 0;
//        }
//        int len = 1;
//        int[] dp = new int[n+1];
//        dp[len] = nums[0];
//        for (int i = 1; i < n; i++) {
//            if (nums[i] > dp[len]) {
//                dp[++len] = nums[i];
//            } else {
//                int s = 1, t = len+1;
//                while (s < t) {
//                    int m = (s+t) >> 1;
//                    if (dp[m] >= nums[i]) {
//                        t = m;
//                    } else {
//                        s = m+1;
//                    }
//                }
//                dp[s] = nums[i];
//            }
//        }
//        return len;
//    }
//}


//// 2022-04-29-22:17
//class Solution {
//    public int lengthOfLIS(int[] nums) {
//        int n = nums.length;
//        int[] dp = new int[n];
//        int len = 0;
//        for (int num : nums) {
//            if (len == 0 || num > dp[len - 1]) {
//                dp[len++] = num;
//            } else {
//                int s = 0, t = len;
//                while (s < t) {
//                    int m = ((s + t) >> 1);
//                    if (dp[m] >= num) {
//                        t = m;
//                    } else {
//                        s = m + 1;
//                    }
//                }
//                dp[s] = num;
//            }
//        }
//        return len;
//    }
//}


/*
 * @create 2022-07-04-20:13
 */
// 定义：dp[i] 长度为 i 的递增子序列的第 i 个元素的最小值
// 状态转移：从前向后遍历，对于每个元素，在dp中找到第一个大于等于它的元素（假设索引为idx），替换 dp[idx] 这个元素，
//          即可以以这个元素为结尾构造出一个当前索引这么长的严格递增子序列（如 dp[1:idx]）
// 初始化：不用初始化
// 遍历顺序：先正序 nums 再正序 dp
class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n+1];
        int len = 0;
        for (int i = 0; i < n; i++) {
            int j = 1;
            for (; j <= len; j++) {
                if (dp[j] >= nums[i]) {
                    dp[j] = nums[i];
                    break;
                }
            }
            if (j > len) {
                dp[++len] = nums[i];
            }
        }
        return len;
    }
}
// 通过   7 ms	41.2 MB