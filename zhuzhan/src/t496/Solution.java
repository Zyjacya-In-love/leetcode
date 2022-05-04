package t496;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * 496. 下一个更大元素 I
 * https://leetcode-cn.com/problems/next-greater-element-i/
 * @author xzq
 * @create 2022-05-03-18:33
 */
class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> num2idx = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            num2idx.put(nums1[i], i);
        }
        int[] ans = new int[nums1.length];
        Deque<Integer> st = new LinkedList<>();
        for (int i = nums2.length-1; i >= 0; i--) {
            while (!st.isEmpty() && st.peek() <= nums2[i]) {
                st.pop();
            }
            if (num2idx.containsKey(nums2[i])) {
                ans[num2idx.get(nums2[i])] = st.isEmpty() ? -1 : st.peek();
            }
            st.push(nums2[i]);
        }
        return ans;
    }
}
// 通过   3 ms	41.4 MB