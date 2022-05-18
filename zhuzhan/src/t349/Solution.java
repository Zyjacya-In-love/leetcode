package t349;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * 349. 两个数组的交集
 * https://leetcode.cn/problems/intersection-of-two-arrays/
 * @author xzq
 * @create 2022-05-18-9:32
 */
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums1) {
            set.add(num);
        }
        ArrayList<Integer> ans = new ArrayList<>();
        for (int num : nums2) {
            if (set.contains(num)) {
                ans.add(num);
                set.remove(num);
            }
        }
        int[] res = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            res[i] = ans.get(i);
        }
        return res;
    }
}
// 通过   2 ms	41.6 MB