package t977;

/**
 * 977. 有序数组的平方
 * https://leetcode.cn/problems/squares-of-a-sorted-array/
 * @author xzq
 * @create 2022-05-14-13:02
 */
// 从中间向两边扩展
//class Solution {
//    public int[] sortedSquares(int[] nums) {
//        int n = nums.length;
//        int pivot = 0;
//        while (pivot < n && nums[pivot] < 0) pivot++;
//        int left = pivot-1;
//        int right = pivot;
//        int index = 0;
//        int[] ans = new int[n];
//        while (left >= 0 || right < n) {
//            int numLeft = left >= 0 ? Math.abs(nums[left]) : Integer.MAX_VALUE;
//            int numRight = right < n ? nums[right] : Integer.MAX_VALUE;
//            if (numLeft <= numRight) {
//                ans[index] = numLeft*numLeft;
//                left--;
//            } else {
//                ans[index] = numRight*numRight;
//                right++;
//            }
//            index++;
//        }
//        return ans;
//    }
//}
// 通过   1 ms	43 MB

// 从两边向中间遍历，无需判断边界情况
class Solution {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int left = 0;
        int right = n-1;
        int index = n-1;
        int[] ans = new int[n];
        while (left <= right) {
            if (Math.abs(nums[left]) <= Math.abs(nums[right])) {
                ans[index] = nums[right]*nums[right];
                right--;
            } else {
                ans[index] = nums[left]*nums[left];
                left++;
            }
            index--;
        }
        return ans;
    }
}
// 通过   1 ms	43.2 MB