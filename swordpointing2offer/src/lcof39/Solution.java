package lcof39;

import java.util.HashMap;
import java.util.Map;

/**
 * 剑指 Offer 39. 数组中出现次数超过一半的数字
 * https://leetcode-cn.com/problems/shu-zu-zhong-chu-xian-ci-shu-chao-guo-yi-ban-de-shu-zi-lcof/
 * @author xzq
 * @create 2022-03-28-8:53
 */
class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> cnt = new HashMap<>();
        int n = nums.length;
        for (int num : nums) {
            cnt.put(num, cnt.getOrDefault(num, 0) + 1);
            if (cnt.get(num) > n/2) {
                return num;
            }
        }
        return -1;
    }
}