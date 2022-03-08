package t1996;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 1996. 游戏中弱角色的数量
 * https://leetcode-cn.com/problems/the-number-of-weak-characters-in-the-game/
 * @author xzq
 * @create 2022-03-08-10:21
 */
class Solution {
    public int numberOfWeakCharacters(int[][] properties) {
        Arrays.sort(properties, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return (o1[0] == o2[0]) ? (o1[1] - o2[1]) : (o2[0] - o1[0]);
            }
        });
        int maxDefense = properties[0][1];
        int ans = 0;
        for (int i = 1; i < properties.length; i++) {
            if (maxDefense > properties[i][1]) {
                ans++;
            } else if (maxDefense < properties[i][1]) {
                maxDefense = properties[i][1];
            }
        }
        return ans;
    }
}
