package t347;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 347. 前 K 个高频元素
 * https://leetcode.cn/problems/top-k-frequent-elements/
 * @author xzq
 * @create 2022-05-21-14:47
 */
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> cnt = new HashMap<>();
        for (int num : nums) {
            cnt.put(num, cnt.getOrDefault(num, 0)+1);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> priorityQueue = new PriorityQueue<>((a, b) -> {
            return Integer.compare(a.getValue(), b.getValue());
        });
        for (Map.Entry<Integer, Integer> c : cnt.entrySet()) {
            priorityQueue.offer(c);
            if (priorityQueue.size() > k) {
                priorityQueue.poll();
            }
        }
        int[] ans = new int[k];
        int idx = k-1;
        while (!priorityQueue.isEmpty()) {
            ans[idx--] = priorityQueue.poll().getKey();
        }
        return ans;
    }
}
// 通过   16 ms	43.5 MB