package t166;

import java.util.HashMap;

/**
 * @title 166. 分数到小数
 * @link https://leetcode.cn/problems/fraction-to-recurring-decimal/
 * @from leetcode top 145
 * @author xzq
 * @create 2022-07-23-18:30
 */
// 想到了模拟除法，唯一没想到的是 怎么判断循环节的出现，下面是官解的一段话
// 如何判断是否找到循环节？注意到对于相同的余数，计算得到的小数的下一位数字一定是相同的，
// 因此如果计算过程中发现某一位的余数在之前已经出现过，则为找到循环节。
// 为了记录每个余数是否已经出现过，需要使用哈希表存储每个余数在小数部分第一次出现的下标。
class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        long numeratorLong = numerator; // 错 1. 次：能除尽也可能超范围，eg：-2147483648 -1
        long denominatorLong = denominator;
        if (numerator % denominator == 0) {
            return String.valueOf(numeratorLong/denominatorLong);
        }
        int flag = 1;
        if (numerator < 0) {
            numeratorLong = -numeratorLong;
            flag = -flag;
        }
        if (denominator < 0) {
            denominatorLong = -denominatorLong;
            flag = -flag;
        }
        StringBuilder sb = new StringBuilder();
        if (flag < 0) {
            sb.append('-');
        }
        sb.append(numeratorLong/denominatorLong);
        sb.append('.');

        HashMap<Long, Integer> map = new HashMap<>();
        long reminder = numeratorLong%denominatorLong;
        int idx = 0;
        StringBuilder fractionalPart = new StringBuilder();
        while (reminder != 0 && !map.containsKey(reminder)) {
            map.put(reminder, idx);
            reminder *= 10;
            fractionalPart.append(reminder/denominatorLong);
            reminder %= denominatorLong;
            idx++;
        }
        if (reminder != 0) {
            int lPos = map.get(reminder);
            fractionalPart.insert(lPos, '(');
            fractionalPart.append(')');
        }
        sb.append(fractionalPart);
        return sb.toString();
    }
}
// 通过   1 ms	39.2 MB