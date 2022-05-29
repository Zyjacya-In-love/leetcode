package t17;

import java.util.ArrayList;
import java.util.List;

/**
 * 17. 电话号码的字母组合
 * https://leetcode.cn/problems/letter-combinations-of-a-phone-number/
 * @author xzq
 * @create 2022-05-29-13:20
 */
class Solution {

    private String[] number2Chars = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    private StringBuilder path;
    private List<String> res;

    public List<String> letterCombinations(String digits) {
        path = new StringBuilder();
        res = new ArrayList<>();
        backtrack(digits, 0);
        return res;
    }

    private void backtrack(String digits, int index) {
        if (index == digits.length()) {
            if (path.length() > 0) {
                res.add(path.toString());
            }
            return;
        }
        char input = digits.charAt(index);
        if (!Character.isDigit(input)) {
            backtrack(digits, index+1);
            return;
        }
        String chars = number2Chars[input-'0'];
        for (int i = 0; i < chars.length(); i++) {
            path.append(chars.charAt(i));
            backtrack(digits, index+1);
            path.deleteCharAt(path.length()-1);
        }
    }
}
// 通过   0 ms	39.7 MB
