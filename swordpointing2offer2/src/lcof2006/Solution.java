package lcof2006;

import java.util.HashMap;

/**
 * 剑指 Offer II 006. 排序数组中两个数字之和
 * https://leetcode-cn.com/problems/kLl5u1/
 * @author xzq
 * @create 2022-03-08-9:20
 */
public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            hm.put(numbers[i], i);
        }
        int[] ans = new int[2];
        for (int i = 0; i < numbers.length; i++) {
            int anothnum = target-numbers[i];
            if (anothnum == numbers[i] && numbers[i] == numbers[i+1]) {
                ans[0] = i;
                ans[1] = i+1;
                break;
            }
            if (hm.containsKey(anothnum)) {
                ans[0] = i;
                ans[1] = hm.get(anothnum);
                break;
            }
        }
        return ans;
    }
}
