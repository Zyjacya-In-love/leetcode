package lcof2038;

import java.util.Stack;

/**
 * 剑指 Offer II 038. 每日温度
 * https://leetcode-cn.com/problems/iIQa4I/
 * @author xzq
 * @create 2022-03-08-9:42
 */
public class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> st = new Stack<>();
        st.push(0);
        int n = temperatures.length;
        int[] res = new int[n];
        for (int i = 1; i < n; i++) {
            while (!st.isEmpty() && temperatures[i] > temperatures[st.peek()]) {
                res[st.peek()] = i-st.peek();
                st.pop();
            }
            st.push(i);
        }
        return res;
    }
}
