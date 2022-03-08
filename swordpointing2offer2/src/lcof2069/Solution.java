package lcof2069;

/**
 * 剑指 Offer II 069. 山峰数组的顶部
 * https://leetcode-cn.com/problems/B1IidL/
 * @author xzq
 * @create 2022-03-08-9:53
 */
class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int s = 0, t = arr.length;
        while (s < t) {
            int m = (s+t)>>1;
            if (arr[m] > arr[m-1] && arr[m] > arr[m+1]) return m;
            if (arr[m] > arr[m-1] && arr[m] < arr[m+1]) s = m+1;
            else if (arr[m] < arr[m-1] && arr[m] > arr[m+1]) t = m;
        }
        return s;
    }
}
