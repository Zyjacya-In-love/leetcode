package t239;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 239. 滑动窗口最大值
 * https://leetcode-cn.com/problems/sliding-window-maximum/
 * @author xzq
 * @create 2022-05-03-19:02
 */
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[n-k+1];
        Deque<Integer> q = new LinkedList<>();
        for (int i = 0; i < k - 1; i++) {
            while (!q.isEmpty() && q.peekLast() < nums[i]) {
                q.pollLast();
            }
            q.offer(nums[i]);
        }
        for (int i = k-1; i < n; i++) {
            while (!q.isEmpty() && q.peekLast() < nums[i]) {
                q.pollLast();
            }
            q.offer(nums[i]);

            ans[i-k+1] = q.peek();

            if (q.peek() == nums[i-k+1]) {
                q.pollFirst();
            }
        }
        return ans;
    }
}
// 通过   29 ms	51.4 MB