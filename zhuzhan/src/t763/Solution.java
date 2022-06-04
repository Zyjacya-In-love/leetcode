package t763;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 763. 划分字母区间
 * https://leetcode.cn/problems/partition-labels/
 * @author xzq
 * @create 2022-06-04-15:09
 */
//      贪心：每次取符合要求的最短的片段，最后得到的片段数就是最多的
class Solution {
    public List<Integer> partitionLabels(String s) {
        int[] charMaxRightPos = new int[30];
        for (int i = 0; i < s.length(); i++) {
            charMaxRightPos[s.charAt(i)-'a'] = i;
        }
        int currEnd = 0;
        int cnt = 0;
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            currEnd = Math.max(currEnd, charMaxRightPos[s.charAt(i)-'a']);
            cnt++;
            if (currEnd == i) {
                res.add(cnt);
                cnt = 0;
            }
        }
        return res;
    }
}
// 通过   4 ms	39.7 M