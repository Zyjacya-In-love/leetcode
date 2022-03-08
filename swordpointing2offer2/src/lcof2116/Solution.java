package lcof2116;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 剑指 Offer II 116. 省份数量
 * https://leetcode-cn.com/problems/bLyHh0/
 * @author xzq
 * @create 2022-03-08-10:10
 */
public class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int ans = 0;
        Deque<Integer> q = new LinkedList<>();
        boolean[] vis = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (vis[i]) continue;
            q.push(i);
            vis[i] = true;
            while (!q.isEmpty()) {
                int now = q.poll();
                for (int j = 0; j < isConnected[now].length; j++) {
                    if (isConnected[now][j] == 1 && vis[j] == false) {
                        q.offer(j);
                        vis[j] = true;
                    }
                }
            }
            ans++;
        }
        return ans;
    }
}
