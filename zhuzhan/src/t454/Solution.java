package t454;

import java.util.HashMap;

/**
 * 454. 四数相加 II
 * https://leetcode.cn/problems/4sum-ii/
 * @author xzq
 * @create 2022-05-18-12:03
 */
class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        HashMap<Integer, Integer> cnt = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                int sum = nums1[i]+nums2[j];
                cnt.put(sum, cnt.getOrDefault(sum, 0)+1);
            }
        }
        int ans = 0;
        for (int i = 0; i < nums3.length; i++) {
            for (int j = 0; j < nums4.length; j++) {
                int other = 0-nums3[i]-nums4[j];
                if (cnt.containsKey(other)) {
                    ans += cnt.get(other);
                }
            }
        }
        return ans;
    }
}
// 通过   129 ms	41.3 MB
