package lcof09;

import java.util.Deque;
import java.util.LinkedList;

/**
 * // 剑指 Offer 09. 用两个栈实现队列
 * // https://leetcode-cn.com/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof/
 * @author xzq
 * @create 2022-03-07-19:27
 */
class CQueue {
    private Deque<Integer> stIn;
    private Deque<Integer> stOut;

    public CQueue() {
        stIn = new LinkedList<>();
        stOut = new LinkedList<>();
    }

    public void appendTail(int value) {
        stIn.push(value);
    }

    public int deleteHead() {
        if (stOut.isEmpty()) {
            while (!stIn.isEmpty()) {
                int val = stIn.pop();
                stOut.push(val);
            }
        }
        return stOut.isEmpty() ? -1 : stOut.pop();
    }
}
