package t79;

/**
 * 79. 单词搜索
 * https://leetcode.cn/problems/word-search/
 * @author xzq
 * @create 2022-07-15-21:36
 */
class Solution {
    private int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    private boolean[][] vis; // 失误 1. 次：忘记判断不能回退了
    private boolean ans = false;

    public boolean exist(char[][] board, String word) {
        vis = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) { // 错 1. 次：只从 [0,0] 开始找了，忘记每个位置都可以当作开始字符了 eg：[["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]] "SEE"
            for (int j = 0; j < board[0].length; j++) {
                dfs(i, j, board, word, 0);
            }
        }
        return ans;
    }

    private void dfs(int x, int y, char[][] board, String word, int i) {
        if (i == word.length()-1 && board[x][y] == word.charAt(i)) { // 错 2. 次：用 i == word.length() 判断的话只有当所有字符都匹配上了，并且还能继续往外扩展时才能到这个判断
            ans = true;
            return;
        }
        vis[x][y] = true;
        if (board[x][y] == word.charAt(i)) {
            for (int j = 0; j < 4; j++) {
                int nx = x+dir[j][0];
                int ny = y+dir[j][1];
                if ((nx >= 0 && nx < board.length) && (ny >= 0 && ny < board[0].length)) {
                    if (vis[nx][ny]) { // 错 3. 次：把 if (vis[x][y]) 放在 for 外面会出现 最后一个字符往回找了，但正好成功的情况，eg：[["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]] "ABCB"
                        continue;
                    }
                    dfs(nx, ny, board, word, i+1);
                    if (ans) {
                        return;
                    }
                }
            }
        }
        vis[x][y] = false;
    }
}
// 通过   127 ms	39.7 MB