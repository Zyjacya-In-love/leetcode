package t225;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 225. 用队列实现栈
 * https://leetcode.cn/problems/implement-stack-using-queues/
 * @author xzq
 * @create 2022-05-21-9:25
 */
class MyStack {

    private Deque<Integer> queue;

    public MyStack() {
        queue = new LinkedList<>();
    }

    public void push(int x) {
        queue.offer(x);
    }

    public int pop() {
        int len = queue.size();
        for (int i = 0; i < len - 1; i++) {
            queue.offer(queue.poll());
        }
        return queue.poll();
    }

    public int top() {
        int res = pop();
        queue.offer(res);
        return res;
    }

    public boolean empty() {
        return queue.isEmpty();
    }
}
// 通过   0 ms	39.3 MB

/*
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
