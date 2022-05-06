package t1;

import java.util.HashMap;

/**
 * 1. 两数之和
 * https://leetcode-cn.com/problems/two-sum/
 * @author xzq
 * @create 2022-05-06-9:57
 */
//class Solution {
//    public int[] twoSum(int[] nums, int target) {
//        HashMap<Integer, Integer> num2Idx = new HashMap<>();
//        for (int i = 0; i < nums.length; i++) {
//            num2Idx.put(nums[i], i);
//        }
//        for (int i = 0; i < nums.length; i++) {
//            int other = target-nums[i];
//            if (num2Idx.containsKey(other) && num2Idx.get(other) != i) {
//                return new int[]{i, num2Idx.get(other)};
//            }
//        }
//        return new int[]{-1, -1};
//    }
//}
// 通过   4 ms	41.9 MB

// 这样我们创建一个哈希表，对于每一个 x，我们首先查询哈希表中是否存在 target - x，
// 然后将 x 插入到哈希表中，即可保证不会让 x 和自己匹配。
class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> num2Idx = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int other = target-nums[i];
            if (num2Idx.containsKey(other)) {
                return new int[]{num2Idx.get(other), i};
            }
            num2Idx.put(nums[i], i);
        }
        return new int[]{-1, -1};
    }
}