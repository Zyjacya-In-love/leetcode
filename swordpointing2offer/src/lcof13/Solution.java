package lcof13;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 剑指 Offer 13. 机器人的运动范围
 * https://leetcode-cn.com/problems/ji-qi-ren-de-yun-dong-fan-wei-lcof/
 * @author xzq
 * @create 2022-03-20-0:28
 */
class Solution {
    public int movingCount(int m, int n, int k) {
        int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        boolean[][] vis = new boolean[m][n];
        Deque<Node> q = new LinkedList<>();
        q.offer(new Node(0, 0));
        vis[0][0] = true;
        int ans = 1;
        while (!q.isEmpty()) {
            Node now = q.poll();
            for (int i = 0; i < 4; i++) {
                int x = now.x + dir[i][0];
                int y = now.y + dir[i][1];
                if ((x >=0 && x < m) && (y >= 0 && y < n)) {
                    if (!vis[x][y] && bitSum(x)+bitSum(y) <= k) {
                        q.offer(new Node(x, y));
                        vis[x][y] = true;
                        ans++;
                    }
                }
            }
        }
        return ans;
    }
    private int bitSum(int x) {
        int res = 0;
        while (x > 0) {
            res += (x%10);
            x /= 10;
        }
        return res;
    }
    private class Node {
        int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
