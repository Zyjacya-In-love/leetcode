package t200;

/**
 * @title 200. 岛屿数量
 * @link https://leetcode.cn/problems/number-of-islands/
 * @from leetcode top 145
 * @author xzq
 * @create 2022-08-01-11:52
 */
// 对于每个 是  1 的位置 dfs，dfs 的时候把经过的位置变为 0，避免重复访问，dfs 的次数即是 连通块 数量
class Solution {
    public int numIslands(char[][] grid) {
        int cnt = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    cnt++;
                }
            }
        }
        return cnt;
    }

    private int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    private void dfs(char[][] grid, int x, int y) {
        grid[x][y] = '0';
        for (int i = 0; i < dir.length; i++) {
            int nx = x + dir[i][0];
            int ny = y + dir[i][1];
            if ((nx >= 0 && nx < grid.length) && (ny >= 0 && ny < grid[0].length)) {
                if (grid[nx][ny] == '1') {
                    dfs(grid, nx, ny);
                }
            }
        }
    }
}
// 通过   3 ms	49.5 MB
