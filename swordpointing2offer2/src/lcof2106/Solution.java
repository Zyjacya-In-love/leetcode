package lcof2106;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 剑指 Offer II 106. 二分图
 * https://leetcode-cn.com/problems/vEAB3K/
 * @author xzq
 * @create 2022-03-08-10:06
 */
class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] vis = new int[n];
        for (int i = 0; i < n; i++) {
            if (vis[i] == 0) {
                vis[i] = 1;
                Queue<Integer> q = new LinkedList<>();
                q.offer(i);
                while (!q.isEmpty()) {
                    int now = q.poll();
                    for (int j = 0; j < graph[now].length; j++) {
                        if (vis[graph[now][j]] == 0) {
                            vis[graph[now][j]] = -vis[now];
                            q.offer(graph[now][j]);
                        }
                        else {
                            if (vis[graph[now][j]] == vis[now]) {
                                return false;
                            }
                        }
                    }
                }
            }
        }
        return true;
    }
}
