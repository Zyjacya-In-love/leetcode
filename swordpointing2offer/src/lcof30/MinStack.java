package lcof30;

import java.util.Deque;
import java.util.LinkedList;

/**
 * // 剑指 Offer 30. 包含min函数的栈
 * // https://leetcode-cn.com/problems/bao-han-minhan-shu-de-zhan-lcof/
 * @author xzq
 * @create 2022-03-07-19:28
 */
class MinStack {

    private Deque<Integer> stack;
    private Deque<Integer> minStack;

    /** initialize your data structure here. */
    public MinStack() {
        stack = new LinkedList<>();
        minStack = new LinkedList<>();
    }

    public void push(int x) {
        stack.push(x);
        if (minStack.isEmpty() || x <= minStack.peek()) {
            minStack.push(x);
        }
    }

    public void pop() {
        int x = stack.pop();
        if (x == minStack.peek()) {
            minStack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return minStack.peek();
    }
}
