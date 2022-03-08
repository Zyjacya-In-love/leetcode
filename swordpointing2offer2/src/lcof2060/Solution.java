package lcof2060;

import java.util.*;

/**
 * 剑指 Offer II 060. 出现频率最高的 k 个数字
 * https://leetcode-cn.com/problems/g5c51o/
 * @author xzq
 * @create 2022-03-08-9:50
 */
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> cnt = new HashMap<>();
        for (int num : nums) {
            cnt.put(num, cnt.getOrDefault(num, 0)+1);
        }
        Queue<Map.Entry<Integer, Integer>> q = new PriorityQueue<Map.Entry<Integer, Integer>>(new Comparator<Map.Entry<Integer, Integer>>() {
            public int compare(Map.Entry<Integer, Integer> i1, Map.Entry<Integer, Integer> i2) {
                return i1.getValue()-i2.getValue();
            }
        });
        for (Map.Entry<Integer, Integer> x : cnt.entrySet()) {
            q.add(x);
            if (q.size() > k) {
                q.poll();
            }
        }
        int[] ans = new int[k];
        int i = 0;
        for (Map.Entry<Integer, Integer> x : q) {
            ans[i++] = x.getKey();
        }
        return ans;
    }
}
