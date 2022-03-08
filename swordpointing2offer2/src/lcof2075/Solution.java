package lcof2075;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

/**
 * 剑指 Offer II 075. 数组相对排序
 * https://leetcode-cn.com/problems/0H97ZC/
 * @author xzq
 * @create 2022-03-08-9:58
 */
class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int n = arr1.length;
        HashMap<Integer, Integer> cnt = new HashMap<>();
        for (int i = 0; i < n; i++) {
            cnt.put(arr1[i], cnt.getOrDefault(arr1[i], 0) + 1);
        }
        int[] res = new int[n];
        int k = 0;
        for (int i = 0; i < arr2.length; i++) {
            for (int j = 0; j < cnt.get(arr2[i]); j++) {
                res[k++] = arr2[i];
            }
            cnt.remove(arr2[i]);
        }
        ArrayList<Integer> tmp = new ArrayList<>(cnt.keySet());
        tmp.sort(Comparator.naturalOrder());
        for (int i = 0; i < tmp.size(); i++) {
            for (int j = 0; j < cnt.get(tmp.get(i)); j++) {
                res[k++] = tmp.get(i);
            }
        }
        return res;
    }
}
