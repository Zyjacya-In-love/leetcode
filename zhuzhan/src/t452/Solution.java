package t452;

import java.util.Arrays;

/**
 * 452. 用最少数量的箭引爆气球
 * https://leetcode.cn/problems/minimum-number-of-arrows-to-burst-balloons/
 * @author xzq
 * @create 2022-05-13-14:46
 */
//class Solution {
//    public int findMinArrowShots(int[][] points) {
//        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));
//        int cnt = 1;
//        int lastEnd = points[0][1];
//        for (int i = 1; i < points.length; i++) {
//            if (points[i][0] > lastEnd) {
//                cnt++;
//                lastEnd = points[i][1];
//            }
//        }
//        return cnt;
//    }
//}
// 通过   53 ms	77.1 MB


/*
 * @create 2022-06-03-22:09
 */
class Solution {
    public int findMinArrowShots(int[][] points) {
        int n = points.length;
        if (n == 0) {
            return 0;
        }
        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));
        int lastRight = points[0][1];
        int ans = 1;
        for (int i = 1; i < n; i++) {
            if (points[i][0] > lastRight) {
                ans++;
                lastRight = points[i][1];
            }
        }
        return ans;
    }
}
// 通过   62 ms	77.9 MB