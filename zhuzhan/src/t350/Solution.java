package t350;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * 350. 两个数组的交集 II
 * https://leetcode.cn/problems/intersection-of-two-arrays-ii/
 * @author xzq
 * @create 2022-05-18-9:50
 */
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> cnt1 = new HashMap<>();
        HashMap<Integer, Integer> cnt2 = new HashMap<>();
        for (int num : nums1) {
            cnt1.put(num, cnt1.getOrDefault(num, 0)+1);
        }
        for (int num : nums2) {
            cnt2.put(num, cnt2.getOrDefault(num, 0)+1);
        }
        ArrayList<Integer> ans = new ArrayList<>();
        for (int key : cnt1.keySet()) {
            if (cnt2.containsKey(key)) {
                for (int i = 0; i < Math.min(cnt1.get(key), cnt2.get(key)); i++) {
                    ans.add(key);
                }
            }
        }
        int[] res = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            res[i] = ans.get(i);
        }
        return res;
    }
}
// 通过   4 ms	41.7 MB