package t13;

import java.util.HashMap;

/**
 * 13. 罗马数字转整数
 * https://leetcode.cn/problems/roman-to-integer/
 * @author xzq
 * @create 2022-07-12-15:15
 */
// 把特殊字符 IV、IX、XL、XC、CD、CM，放进特殊 map，
// 每次取两个字符组成 String 看在不在特殊 map keys 里，没有直接取 一个字符的 map 的 value
class Solution {
    public int romanToInt(String s) {
        HashMap<String, Integer> comVal = new HashMap<>();
        comVal.put("IV", 4);
        comVal.put("IX", 9);
        comVal.put("XL", 40);
        comVal.put("XC", 90);
        comVal.put("CD", 400);
        comVal.put("CM", 900);
        HashMap<Character, Integer> oneVal = new HashMap<>();
        oneVal.put('I' ,1);
        oneVal.put('V' ,5);
        oneVal.put('X' ,10);
        oneVal.put('L' ,50);
        oneVal.put('C' ,100);
        oneVal.put('D' ,500);
        oneVal.put('M' ,1000);
        int n = s.length();
        int ans = 0;
        int i = 0;
        for (; i < n-1; i++) {
            String tmp = s.substring(i, i+2);
            if (comVal.containsKey(tmp)) {
                ans += comVal.get(tmp);
                i++;
            } else {
                ans += oneVal.get(s.charAt(i));
            }
        }
        if (i < n) {
            ans += oneVal.get(s.charAt(i));
        }
        return ans;
    }
}
// 通过   5 ms	41.9 MB