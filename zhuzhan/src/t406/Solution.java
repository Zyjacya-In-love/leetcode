package t406;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 406. 根据身高重建队列
 * https://leetcode.cn/problems/queue-reconstruction-by-height/
 * @author xzq
 * @create 2022-06-05-13:27
 */
class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a, b) -> {
            int tmp = Integer.compare(a[0], b[0]);
            if (tmp == 0) {
                return Integer.compare(a[1], b[1]);
            } else {
                return -tmp;
            }
        });
        LinkedList<int[]> res = new LinkedList<>();
        for (int i = 0; i < people.length; i++) {
            res.add(people[i][1], people[i]);
        }
        return res.toArray(new int[res.size()][]);
    }
}
// 通过   7 ms	42.3 MB