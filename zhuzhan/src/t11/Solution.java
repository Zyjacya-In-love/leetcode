package t11;

/**
 * 11. 盛最多水的容器
 * https://leetcode.cn/problems/container-with-most-water/
 * @author xzq
 * @create 2022-05-13-8:18
 */
class Solution {
    public int maxArea(int[] height) {
        int n = height.length;
        int left = 0;
        int right = n-1;
        int ans = 0;
        while (left < right) {
            ans = Math.max(ans, Math.min(height[left], height[right])*(right-left));
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return ans;
    }
}
