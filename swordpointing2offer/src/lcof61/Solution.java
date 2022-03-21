package lcof61;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 剑指 Offer 61. 扑克牌中的顺子
 * https://leetcode-cn.com/problems/bu-ke-pai-zhong-de-shun-zi-lcof/
 * @author xzq
 * @create 2022-03-21-23:33
 */
class Solution {
    public boolean isStraight(int[] nums) {
        Arrays.sort(nums);
        int zeroNum = 0;
        for (int i = 0; i < nums.length-1; i++) {
            if (nums[i] != 0) {
                if (nums[i]+1 > nums[i+1] || nums[i+1]-(nums[i]+1) > zeroNum) {
                    return false;
                }
                zeroNum -= (nums[i+1]-(nums[i]+1));
            } else {
                zeroNum++;
            }
        }
        return true;
    }
}