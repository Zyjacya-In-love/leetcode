package t599;

import java.util.*;

/**
 * 599. 两个列表的最小索引总和
 * https://leetcode-cn.com/problems/minimum-index-sum-of-two-lists/
 * @author xzq
 * @create 2022-03-14-21:55
 */
class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> restaurantIdx = new HashMap<>();
        for (int i = 0; i < list1.length; i++) {
            restaurantIdx.put(list1[i], i);
        }
        List<String> ans = new ArrayList<>();
        int nowMinSumIdx = Integer.MAX_VALUE;
        for (int i = 0; i < list2.length; i++) {
            if (i > nowMinSumIdx) break;
            if (restaurantIdx.containsKey(list2[i])) {
                if (restaurantIdx.get(list2[i])+i == nowMinSumIdx) {
                    ans.add(list2[i]);
                } else if (restaurantIdx.get(list2[i])+i < nowMinSumIdx) {
                    ans.clear();
                    ans.add(list2[i]);
                    nowMinSumIdx = restaurantIdx.get(list2[i])+i;
                }
            }
        }
        return ans.toArray(new String[ans.size()]);
    }
}
