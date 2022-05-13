package t130;


/**
 * 130. 被围绕的区域
 * https://leetcode.cn/problems/surrounded-regions/
 * @author xzq
 * @create 2022-05-13-16:25
 */
class Solution {
    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        UnionFind unionFind = new UnionFind(n * m + 1);
        int dummy = n * m;
        for (int i = 0; i < n; i++) {
            if (board[i][0] == 'O') {
                unionFind.union(i*m, dummy);
            }
            if (board[i][m-1] == 'O') {
                unionFind.union(i*m+m-1, dummy);
            }
        }
        for (int j = 0; j < m; j++) {
            if (board[0][j] == 'O') {
                unionFind.union(j, dummy);
            }
            if (board[n-1][j] == 'O') {
                unionFind.union((n-1)*m+j, dummy);
            }
        }
        int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        for (int i = 1; i < n-1; i++) {
            for (int j = 1; j < m-1; j++) {
                if (board[i][j] == 'O') {
                    for (int k = 0; k < dir.length; k++) {
                        int x = i + dir[k][0];
                        int y = j + dir[k][1];
                        if (board[x][y] == 'O') {
                            unionFind.union(x*m+y, i*m+j);
                        }
                    }
                }
            }
        }
        for (int i = 1; i < n-1; i++) {
            for (int j = 1; j < m-1; j++) {
                if (board[i][j] == 'O') {
                    if (!unionFind.connect(i*m+j, dummy)) {
                        board[i][j] = 'X';
                    }
                }
            }
        }
    }
}
class UnionFind {
    private int n;
    private int[] father;
    private int[] size;

    public UnionFind(int n) {
        this.n = n;
        father = new int[n];
        size = new int[n];
        for (int i = 0; i < n; i++) {
            father[i] = i;
            size[i] = 1;
        }
    }

    public void union(int x, int y) {
        int fx = find(x);
        int fy = find(y);
        if (fx == fy) {
            return;
        }
        if (size[fx] > size[fy]) {
            int tmp = fx;
            fx = fy;
            fy = tmp;
        }
        father[fx] = fy;
        size[fy] += size[fx];
    }

    public boolean connect(int x, int y) {
        return find(x) == find(y);
    }

    private int find(int x) {
        while (x != father[x]) {
            x = father[x] = father[father[x]];
        }
        return x;
    }
}
// 通过   5 ms	43.2 MB