package t88;

/**
 * 88. 合并两个有序数组
 * https://leetcode.cn/problems/merge-sorted-array/
 * @author xzq
 * @create 2022-07-15-22:09
 */
// 归并排序的单步操作
// 小 trick 是 从 后往前 合并到 nums1 中去，这样 nums1 中的元素不会被覆盖
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int pos1 = m-1;
        int pos2 = n-1;
        int curr = n+m-1;
        while (pos1 >= 0 && pos2 >= 0) {
            if (nums1[pos1] >= nums2[pos2]) {
                nums1[curr] = nums1[pos1];
                pos1--;
            } else {
                nums1[curr] = nums2[pos2];
                pos2--;
            }
            curr--;
        }
        if (pos2 >= 0) {
            while (pos2 >= 0) {
                nums1[curr] = nums2[pos2];
                pos2--;
                curr--;
            }
        }
    }
}
// 通过   0 ms	41.1 MB