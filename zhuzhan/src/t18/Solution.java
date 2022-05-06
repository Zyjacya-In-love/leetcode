package t18;

import javax.print.DocFlavor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 18. 四数之和
 * https://leetcode-cn.com/problems/4sum/
 * @author xzq
 * @create 2022-05-06-11:10
 */
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> res = nSum(4, nums, 0, target);
        return res;
    }

    private List<List<Integer>> nSum(int n, int[] nums, int start, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (n > 2) {
            for (int i = start; i < nums.length-n+1; i++) {
                if (i > start && nums[i] == nums[i-1]) {
                    continue;
                }
                List<List<Integer>> tmp = nSum(n - 1, nums, i + 1, target - nums[i]);
                for (List<Integer> x : tmp) {
                    x.add(nums[i]);
                    res.add(x);
                }
            }
        } else {
            int left = start, right = nums.length-1;
            while (left < right) {
                int leftNum = nums[left], rightNum = nums[right];
                int sum = leftNum + rightNum;
                if (sum == target) {
                    List<Integer> tmp = new ArrayList<>();
                    tmp.add(leftNum);
                    tmp.add(rightNum);
                    res.add(tmp);
                    while (left < right && nums[left] == leftNum) left++;
                    while (left < right && nums[right] == rightNum) right--;
                } else if (sum < target) {
                    while (left < right && nums[left] == leftNum) left++;
                } else {
                    while (left < right && nums[right] == rightNum) right--;
                }
            }
        }
        return res;
    }
}
// 通过   21 ms	42 MB