package lcof49;

import java.util.PriorityQueue;

/**
 * 剑指 Offer 49. 丑数
 * https://leetcode-cn.com/problems/chou-shu-lcof/
 * @author xzq
 * @create 2022-04-04-10:50
 */
class Solution {
    public int nthUglyNumber(int n) {
        PriorityQueue<Long> pq = new PriorityQueue<>();
        pq.offer(1L);
        while (n > 1) {
            long now = pq.poll();
            if (!(now%3 == 0 || now%5 == 0)) {
                pq.offer(now*2);
            }
            if (!(now%5 == 0)) {
                pq.offer(now*3);
            }
            pq.offer(now*5);
            n--;
            System.out.println(pq.toString());
        }
        return Math.toIntExact(pq.peek());
    }
}