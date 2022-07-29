package t189;

import java.util.Arrays;

/**
 * @title 189. 轮转数组
 * @link https://leetcode.cn/problems/rotate-array/
 * @from leetcode top 145
 * @author xzq
 * @create 2022-07-28-23:11
 */
// 空间 O(1) 的原地算法，swap，
// 一个循环节 k 中的所有元素，每个都向后迁移前 k 个位置，直到回到初始的位置，结束一个循环节，
// 当 swap 了 n 个元素就说明都换到了正确的位置
class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        if (k%n == 0) { // 错 1. 次：k == 0，因为 会除 0；k 是 n 的倍数，不会变
            return;
        }
        int cnt = 0;
        int start = 0;
        while (cnt < n) {
            int curr = start;
            do {
                int next = (curr+k)%n;
                swap(nums, start, next);
                curr = next;
                cnt++;
            } while (curr != start);
            start++; // 错 1. 次：start 没加一，竟然能跑到 31/38，前 30 个sample只有一个循环节 :)
        }
    }

    private void swap(int[] nums, int a, int b) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }
}
// 通过   2 ms	57.2 MB