package t421;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public int findMaximumXOR(int[] nums) {
        int res = 0;
        for (int k = 30; k >= 0; k--) {
            Set<Integer> set = new HashSet<>();
            for (int num : nums) {
                set.add(num>>k);
            }
            int tmp = (res<<1) + 1;
            boolean flag = false;
            for (int num : nums) {
                if (set.contains((num>>k)^tmp)) {
                    flag = true;
                    break;
                }
            }
            res <<= 1;
            if (flag) {
                res++;
            }
        }
        return res;
    }
}