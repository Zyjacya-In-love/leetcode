package t179;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @title 179. 最大数
 * @link https://leetcode.cn/problems/largest-number/
 * @from leetcode top 145
 * @author xzq
 * @create 2022-07-27-23:16
 */
// 重载排序方法
// 错 1. 次：挨个字符比较，大的在前，如果长度不一致，将长度小的最后一个字符和长度大的剩余字符比较，eg：[34323,3432]
// 把两个 数字 前后拼接在一起，分别一前一后，比较那个数大，那个数大，拼接在前面那个数就应该放前面
class Solution {
    public String largestNumber(int[] nums) {
        List<String> res = new ArrayList<>();
        for (int num : nums) {
            res.add(String.valueOf(num));
        }
        Collections.sort(res, (s1, s2) -> {
            String tmp1 = s1+s2;
            String tmp2 = s2+s1;
            int n = tmp1.length();
            int i = 0, j = 0;
            while (i < n || j < n) {
                char c1 = tmp1.charAt(i);
                char c2 = tmp2.charAt(j);
                if (c1 == c2) {
                    i++;
                    j++;
                    continue;
                }
                return c2-c1;
            }
            return 0;
        });
        // 错 2. 次：前导 0，没去除，eg：[0,0]
//        int pos = 0;
//        for (int i = 0; i < res.size(); i++) {
//            if ("0".equals(res.get(i))) {
//                pos++;
//            } else {
//                break;
//            }
//        }
//        if (pos == res.size()) { // 错 3. 次：结果就是 0，eg：[0]
//            return "0";
//        }
        // 我是 sb，如果第一个是 "0"，那必然就是 0，因为任何数都比 0 大，肯定在 0 前面，所以只需要判断第一个是不是 "0"
        if ("0".equals(res.get(0))) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < res.size(); ++i) {
            sb.append(res.get(i));
        }
        return sb.toString();
    }
}
// 通过   4 ms	40.8 MB