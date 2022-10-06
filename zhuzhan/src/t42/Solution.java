package t42;

/**
 * 42. 接雨水
 * https://leetcode.cn/problems/trapping-rain-water/
 * @author xzq
 * @create 2022-05-13-8:01
 */
//class Solution {
//    public int trap(int[] height) {
//        int n = height.length;
//        int[] leftMax = new int[n];
//        int[] rightMax = new int[n];
//        leftMax[0] = height[0];
//        for (int i = 1; i < n; i++) {
//            leftMax[i] = Math.max(leftMax[i-1], height[i]);
//        }
//        rightMax[n-1] = height[n-1];
//        for (int i = n-2; i >= 0; i--) {
//            rightMax[i] = Math.max(rightMax[i+1], height[i]);
//        }
//        int ans = 0;
//        for (int i = 0; i < n; i++) {
//            ans += Math.min(leftMax[i], rightMax[i])-height[i];
//        }
//        return ans;
//    }
//}
// 通过   1 ms	41.6 MB

// 双指针 优化 空间O(1)
//class Solution {
//    public int trap(int[] height) {
//        int n = height.length;
//        int leftMax = height[0];
//        int rightMax = height[n-1];
//        int left = 0;
//        int right = n-1;
//        int ans = 0;
//        while (left < right) {
//            leftMax = Math.max(leftMax, height[left]);
//            rightMax = Math.max(rightMax, height[right]);
//            if (leftMax < rightMax) {
//                ans += leftMax-height[left];
//                left++;
//            } else {
//                ans += rightMax-height[right];
//                right--;
//            }
//        }
//        return ans;
//    }
//}
// 通过   0 ms	42.3 MB


/*
 * @from huawei interview coding https://www.nowcoder.com/discuss/1069532
 * @create 2022-10-06-12:08
 */
class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int leftMax = height[0];
        int rightMax = height[n-1];
        int leftIdx = 0;
        int rightIdx = n-1;
        int res = 0;
        while (leftIdx <= rightIdx) { // error 1 ：忘记写 = ，相等时这个索引位置并没有计算进去，必须加 =
            if (leftMax <= rightMax) {
                leftMax = Math.max(leftMax, height[leftIdx]);
                res += (leftMax-height[leftIdx]);
                leftIdx++;
            } else {
                rightMax = Math.max(rightMax, height[rightIdx]);
                res += (rightMax-height[rightIdx]);
                rightIdx--;
            }
        }
        return res;
    }
}