package t904;


import org.omg.PortableInterceptor.INACTIVE;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/**
 * 904. 水果成篮
 * https://leetcode.cn/problems/fruit-into-baskets/
 * @author xzq
 * @create 2022-05-15-15:38
 */
//class Solution {
//    public int totalFruit(int[] fruits) {
//        int n = fruits.length;
//        int left = 0, right = 0;
//        int[] cnt = new int[n];
//        int p1 = -1, p2 = -1;
//        int size = 0;
//        int maxWin = 0;
//        while (right < n) {
//            if (cnt[fruits[right]] == 0 && size == 2) {
//                while (cnt[fruits[p1]] > 0 && cnt[fruits[p2]] > 0) {
//                    cnt[fruits[left]]--;
//                    left++;
//                }
//                size--;
//                if (cnt[fruits[p1]] == 0) {
//                    p1 = -1;
//                } else {
//                    p2 = -1;
//                }
//            }
//            cnt[fruits[right]]++;
//            if (cnt[fruits[right]] == 1) {
//                size++;
//                if (p1 == -1) {
//                    p1 = right;
//                } else {
//                    p2 = right;
//                }
//            }
//            right++;
//            maxWin = Math.max(maxWin, right-left);
//        }
//        return maxWin;
//    }
//}
// 通过   8 ms	49.1 MB

// HashMap 版本
class Solution {
    public int totalFruit(int[] fruits) {
        int n = fruits.length;
        HashMap<Integer, Integer> cnt = new HashMap<>();
        int left = 0, right = 0;
        int maxWin = 0;
        while (right < n) {
            cnt.put(fruits[right], cnt.getOrDefault(fruits[right], 0)+1);
            while (cnt.size() > 2) {
                cnt.put(fruits[left], cnt.get(fruits[left])-1);
                if (cnt.get(fruits[left]) == 0) {
                    cnt.remove(fruits[left]);
                }
                left++;
            }
            right++;
            maxWin = Math.max(maxWin, right-left);
        }
        return maxWin;
    }
}
// 通过   59 ms	50.4 MB