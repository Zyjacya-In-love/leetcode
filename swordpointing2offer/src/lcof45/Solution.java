package lcof45;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;

/**
 * 剑指 Offer 45. 把数组排成最小的数
 * 剑指 Offer 45. 把数组排成最小的数
 * @author xzq
 * @create 2022-03-21-23:02
 */
class Solution {
    public String minNumber(int[] nums) {
        String[] numsStr = Arrays.stream(nums).mapToObj(String::valueOf).toArray(String[]::new);
        Arrays.sort(numsStr, new Comparator<String>() {
            @Override
            public int compare(String s, String t) {
                String num1 = s+t;
                String num2 = t+s;
                return num1.compareTo(num2);
            }
        });
        return String.join("", numsStr);
    }
}