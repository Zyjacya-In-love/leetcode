package t969;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 969. 煎饼排序
 * https://leetcode.cn/problems/pancake-sorting/
 * @author xzq
 * @create 2022-05-09-14:24
 */
class Solution {
    public List<Integer> pancakeSort(int[] arr) {
        int n = arr.length;
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = n; i >= 1; i--) {
            int pos = 0;
            for (int j = 0; j < i; j++) {
                if (arr[j] == i) {
                    pos = j;
                    break;
                }
            }
            reverse(arr, 0, pos);
            ans.add(pos+1);
            reverse(arr, 0, i-1);
            ans.add(i);
        }
        return ans;
    }

    private void reverse(int[] arr, int left, int right) {
        while (left < right) {
            int tmp = arr[left];
            arr[left] = arr[right];
            arr[right] = tmp;
            left++;
            right--;
        }
    }
}
// 通过   1 ms	41.2 MB
