package t455;

import java.util.Arrays;

/**
 * 455. 分发饼干
 * https://leetcode.cn/problems/assign-cookies/
 * @author xzq
 * @create 2022-06-03-10:14
 */
//      贪心：饼干、孩子都排序，饼干从小到大试，直到满足第一个孩子的胃口，再看第二个孩子的胃口，最后满足孩子的数量就是最多的
//          因为能用上的饼干都用上了，每个孩子用的都是能满足他胃口的最小的饼干，对后面胃口更大的孩子没有影响
class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int childIndex = 0;
        for (int i = 0; i < s.length && childIndex < g.length; i++) {
            if (s[i] >= g[childIndex]) {
                childIndex++;
            }
        }
        return childIndex;
    }
}
// 通过   7 ms	42.2 MB