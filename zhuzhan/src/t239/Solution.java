package t239;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 239. 滑动窗口最大值
 * https://leetcode-cn.com/problems/sliding-window-maximum/
 * @author xzq
 * @create 2022-05-03-19:02
 */
//class Solution {
//    public int[] maxSlidingWindow(int[] nums, int k) {
//        int n = nums.length;
//        int[] ans = new int[n-k+1];
//        Deque<Integer> q = new LinkedList<>();
//        for (int i = 0; i < k - 1; i++) {
//            while (!q.isEmpty() && q.peekLast() < nums[i]) {
//                q.pollLast();
//            }
//            q.offer(nums[i]);
//        }
//        for (int i = k-1; i < n; i++) {
//            while (!q.isEmpty() && q.peekLast() < nums[i]) {
//                q.pollLast();
//            }
//            q.offer(nums[i]);
//
//            ans[i-k+1] = q.peek();
//
//            if (q.peek() == nums[i-k+1]) {
//                q.pollFirst();
//            }
//        }
//        return ans;
//    }
//}
// 通过   29 ms	51.4 MB

/*
 * @create 2022-05-21-10:58
 */
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        MaxQueue maxQueue = new MaxQueue();
        for (int i = 0; i < k - 1; i++) {
            maxQueue.push(nums[i]);
        }
        int[] ans = new int[nums.length-k+1];
        int left = 0;
        int right = k-1;
        while (right < nums.length) {
            maxQueue.push(nums[right]);
            ans[left] = maxQueue.max();
            maxQueue.pop(nums[left]);
            left++;
            right++;
        }
        return ans;
    }
    class MaxQueue {
        Deque<Integer> queue;

        public MaxQueue() {
            queue = new LinkedList<>();
        }

        public void push(int x) {
            while (!queue.isEmpty() && queue.peekLast() < x) {
                queue.pollLast();
            }
            queue.offerLast(x);
        }

        public void pop(int x) {
            if (!queue.isEmpty() && queue.peekFirst() == x) {
                queue.pollFirst();
            }
        }

        public int max() {
            if (queue.isEmpty()) {
                return Integer.MIN_VALUE;
            }
            return queue.peekFirst();
        }
    }
}
// 通过   44 ms	58.1 MB
