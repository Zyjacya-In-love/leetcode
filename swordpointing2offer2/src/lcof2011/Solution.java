package lcof2011;

import java.util.HashMap;

/**
 * 剑指 Offer II 011. 0 和 1 个数相同的子数组
 * https://leetcode-cn.com/problems/A1NYOS/
 * @author xzq
 * @create 2022-03-08-9:23
 */
public class Solution {
    public int findMaxLength(int[] nums) {
        int counter = 0;
        HashMap<Integer, Integer> mp = new HashMap<>();
        int ans = 0;
        mp.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            counter += (nums[i] == 0 ? -1 : 1);
            if (mp.containsKey(counter)) {
                ans = Math.max(ans, i-mp.get(counter));
            }
            else {
                mp.put(counter, i);
            }
        }
        return ans;
    }
}
