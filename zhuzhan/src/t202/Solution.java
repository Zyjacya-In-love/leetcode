package t202;

import java.util.HashSet;

/**
 * 202. 快乐数
 * https://leetcode.cn/problems/happy-number/
 * @author xzq
 * @create 2022-05-18-10:54
 */
class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<>();
        while (!set.contains(n)) {
            if (n == 1) {
                return true;
            }
            set.add(n);
            n = getNext(n);
        }
        return false;
    }

    private int getNext(int n) {
        int res = 0;
        while (n > 0) {
            int tmp = n%10;
            res += tmp*tmp;
            n /= 10;
        }
        return res;
    }
}
// 通过   1 ms	38.5 MB
