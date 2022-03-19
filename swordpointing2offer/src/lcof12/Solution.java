package lcof12;

import java.util.Arrays;

/**
 * 剑指 Offer 12. 矩阵中的路径
 * https://leetcode-cn.com/problems/ju-zhen-zhong-de-lu-jing-lcof/
 * @author xzq
 * @create 2022-03-19-23:55
 */
class Solution {
    private char[][] board;
    private String word;
    boolean[][] vis;
    boolean flag = false;
    int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    int n, m;
    public boolean exist(char[][] board, String word) {
        this.board = board;
        this.word = word;
        n = board.length;
        m = board[0].length;
        vis = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == word.charAt(0)) {
                    for (int k = 0; k < n; k++) {
                        Arrays.fill(vis[k], false);
                    }
                    vis[i][j] = true;
                    dfs(i, j, 1);
                    if (flag) return true;

                }
            }
        }
        return false;
    }
    private void dfs(int x, int y, int pos) {
        if (pos == word.length()) {
            flag = true;
            return;
        }
        for (int i = 0; i < 4; i++) {
            int nx = x + dir[i][0];
            int ny = y + dir[i][1];
            if ((nx >= 0 && nx < n) && (ny >= 0 && ny < m)) {
                if (!vis[nx][ny] && board[nx][ny] == word.charAt(pos)) {
                    vis[nx][ny] = true;
                    dfs(nx, ny, pos+1);
                    if (flag) return;
                    vis[nx][ny] = false;
                }
            }
        }
    }
}
