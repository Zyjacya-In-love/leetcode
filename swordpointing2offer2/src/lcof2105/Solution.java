package lcof2105;

/**
 * 剑指 Offer II 105. 岛屿的最大面积
 * https://leetcode-cn.com/problems/ZL6zAn/
 * @author xzq
 * @create 2022-03-08-10:05
 */
class Solution {
    private int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private int[][] grid;
    private int m, n;
    public int dfs(int x, int y) {
        grid[x][y] = 2;
        int res = 0;
        for (int i = 0; i < 4; i++) {
            int x1 = x + dir[i][0];
            int y1 = y + dir[i][1];
            if ((x1 >= 0 && x1 < m) && (y1 >= 0 && y1 < n) && grid[x1][y1] == 1) {
                res += dfs(x1, y1);
            }
        }
        return res+1;
    }
    public int maxAreaOfIsland(int[][] grid) {
        this.grid = grid;
        this.m = grid.length;
        this.n = grid[0].length;
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    ans = Math.max(ans, dfs(i, j));
                }
            }
        }
        return ans;
    }
}
