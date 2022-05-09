package t560;

import java.util.HashMap;

/**
 * 560. 和为 K 的子数组
 * https://leetcode.cn/problems/subarray-sum-equals-k/
 * @author xzq
 * @create 2022-05-09-14:45
 */
//class Solution {
//    public int subarraySum(int[] nums, int k) {
//        int n = nums.length;
//        int[] sum = new int[n+1];
//        for (int i = 1; i <= n; i++) {
//            sum[i] = sum[i-1] + nums[i-1];
//        }
//        HashMap<Integer, Integer> sumCnt = new HashMap<>();
//        sumCnt.put(0, 1);
//        int ans = 0;
//        for (int i = 1; i <= n; ++i) {
//            int target = sum[i]-k;
//            if (sumCnt.containsKey(target)) {
//                ans += sumCnt.get(target);
//            }
//            sumCnt.put(sum[i], sumCnt.getOrDefault(sum[i], 0)+1);
//        }
//        return ans;
//    }
//}
// 通过   16 ms	44 MB

// 无需前缀数组，用一变量代替即可
class Solution {
    public int subarraySum(int[] nums, int k) {
        int sum = 0;
        HashMap<Integer, Integer> sumCnt = new HashMap<>();
        sumCnt.put(0, 1);
        int ans = 0;
        for (int num : nums) {
            sum += num;
            int target = sum-k;
            if (sumCnt.containsKey(target)) {
                ans += sumCnt.get(target);
            }
            sumCnt.put(sum, sumCnt.getOrDefault(sum, 0)+1);
        }
        return ans;
    }
}
// 通过   21 ms	44 MB