package t128;

import java.util.HashSet;

/**
 * 128. 最长连续序列
 * https://leetcode.cn/problems/longest-consecutive-sequence/
 * @author xzq
 * @create 2022-07-16-21:08
 */
// 用 HashSet 存储 nums 中的所有元素
// 只用 连续开始的最小元素开始尝试一直到连续最大的长度，每次尝试用的是 contains(x+1)，每次结束记录最大长度
// 判断是不是最小的开始元素用的是 contains(x-1)，包含即说明不是最小元素
class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int ans = 0;
        for (int num : set) { // 改成 set 会比 nums 快，因为 nums 中有重复元素
            if (set.contains(num-1)) {
                continue;
            }
            int len = 1;
            while (set.contains(num+1)) {
                len++;
                num++;
            }
            ans = Math.max(ans, len);
        }
        return ans;
    }
}
// 通过   20 ms	59.7 MB