package lcof31;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 剑指 Offer 31. 栈的压入、弹出序列
 * https://leetcode-cn.com/problems/zhan-de-ya-ru-dan-chu-xu-lie-lcof/
 * @author xzq
 * @create 2022-03-30-20:53
 */
class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Deque<Integer> q = new LinkedList<>();
        int popIdx = 0;
        for (int i = 0; i < pushed.length; i++) {
            q.push(pushed[i]);
            while (!q.isEmpty() && q.peekFirst() == popped[popIdx]) {
                q.pop();
                popIdx++;
            }
        }
        return q.isEmpty();
    }
}