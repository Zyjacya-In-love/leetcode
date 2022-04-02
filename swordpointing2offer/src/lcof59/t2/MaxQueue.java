package lcof59.t2;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 剑指 Offer 59 - II. 队列的最大值
 * https://leetcode-cn.com/problems/dui-lie-de-zui-da-zhi-lcof/
 * @author xzq
 * @create 2022-04-02-8:31
 */
class MaxQueue {

    private Deque<Integer> dataQueue;
    private Deque<Integer> maxValueQueue;

    public MaxQueue() {
        dataQueue = new LinkedList<>();
        maxValueQueue = new LinkedList<>();
    }

    public int max_value() {
        if (maxValueQueue.isEmpty()) return -1;
        return maxValueQueue.peekFirst();
    }

    public void push_back(int value) {
        dataQueue.offer(value);
        while (!maxValueQueue.isEmpty() && maxValueQueue.peekLast() < value) {
            maxValueQueue.pollLast();
        }
        maxValueQueue.offerLast(value);
    }

    public int pop_front() {
        if (dataQueue.isEmpty()) return -1;
        int res = dataQueue.poll();
        if (res == maxValueQueue.peekFirst()) {
            maxValueQueue.pollFirst();
        }
        return res;
    }
}

/**
 * Your MaxQueue object will be instantiated and called as such:
 * MaxQueue obj = new MaxQueue();
 * int param_1 = obj.max_value();
 * obj.push_back(value);
 * int param_3 = obj.pop_front();
 */
