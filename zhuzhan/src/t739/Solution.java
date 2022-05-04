package t739;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 739. 每日温度
 * https://leetcode-cn.com/problems/daily-temperatures/
 * @author xzq
 * @create 2022-05-03-18:48
 */
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] answer = new int[n];
        Deque<Integer> st = new LinkedList<>();
        for (int i = n-1; i >= 0; i--) {
            while (!st.isEmpty() && temperatures[st.peek()] <= temperatures[i]) {
                st.pop();
            }
            answer[i] = st.isEmpty() ? 0 : st.peek()-i;
            st.push(i);
        }
        return answer;
    }
}
// 通过   25 ms	56.7 MB
