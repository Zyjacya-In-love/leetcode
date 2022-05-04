package t503;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 503. 下一个更大元素 II
 * https://leetcode-cn.com/problems/next-greater-element-ii/
 * @author xzq
 * @create 2022-05-03-18:55
 */
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        Deque<Integer> st = new LinkedList<>();
        for (int i = 2*n-1; i >= 0; i--) {
            while (!st.isEmpty() && st.peek() <= nums[i%n]) {
                st.pop();
            }
            ans[i%n] = st.isEmpty() ? -1 : st.peek();
            st.push(nums[i%n]);
        }
        return ans;
    }
}
// 通过   5 ms	42.7 MB