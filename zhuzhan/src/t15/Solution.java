package t15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 15. 三数之和
 * https://leetcode-cn.com/problems/3sum/
 * @author xzq
 * @create 2022-05-06-10:21
 */
public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> tuples = new ArrayList<>();
        int n = nums.length;
        for (int i = 0; i < nums.length-2; i++) {
            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            List<List<Integer>> twoRes = twoSum(nums, i+1, n-1, 0-nums[i]);
            for (List<Integer> two : twoRes) {
                two.add(nums[i]);
                tuples.add(two);
            }
        }
        return tuples;
    }

    private List<List<Integer>> twoSum(int[] nums, int left, int right, int target) {
        List<List<Integer>> res = new ArrayList<>();
        while (left < right) {
            int numLeft = nums[left];
            int numRight = nums[right];
            int sum = numLeft + numRight;
            if (sum == target) {
                List<Integer> tmp = new ArrayList<Integer>();
                tmp.add(nums[left]);
                tmp.add(nums[right]);
                res.add(tmp);
                while (left < right && nums[left] == numLeft) left++;
                while (left < right && nums[right] == numRight) right--;
            } else if (sum < target) {
                while (left < right && nums[left] == numLeft) left++;
            } else {
                while (left < right && nums[right] == numRight) right--;
            }
        }
        return res;
    }
}
// 通过   34 ms	45.7 MB
