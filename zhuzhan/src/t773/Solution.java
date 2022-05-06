package t773;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;

/**
 * 773. 滑动谜题
 * https://leetcode-cn.com/problems/sliding-puzzle/
 * @author xzq
 * @create 2022-05-06-9:29
 */
class Solution {
    public int slidingPuzzle(int[][] board) {
        int[][] neighbor = {{1, 3},
                            {0, 2, 4},
                            {1, 5},
                            {0, 4},
                            {1, 3, 5},
                            {2, 4}};
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                sb.append(board[i][j]);
            }
        }
        String start = sb.toString();
        String target = "123450";
        Deque<String> q = new LinkedList<>();
        HashSet<String> vis = new HashSet<>();
        q.offer(start);
        vis.add(start);
        int step = 0;
        while (!q.isEmpty()) {
            int len = q.size();
            for (int i = 0; i < len; i++) {
                String now = q.poll();
                char[] nowChars = now.toCharArray();
                if (now.equals(target)) {
                    return step;
                }
                int idx0 = 0;
                for (int j = 0; j < now.length(); j++) {
                    if (nowChars[j] == '0') {
                        idx0 = j;
                        break;
                    }
                }
                for (int nei : neighbor[idx0]) {
                    swap(nowChars, idx0, nei);
                    String next = new String(nowChars);
                    if (!vis.contains(next)) {
                        q.offer(next);
                        vis.add(next);
                    }
                    swap(nowChars, idx0, nei);
                }
            }
            step++;
        }
        return -1;
    }

    private void swap(char[] nowChars, int i, int j) {
        char tmp = nowChars[i];
        nowChars[i] = nowChars[j];
        nowChars[j] = tmp;
    }
}
// 通过   6 ms	40.6 MB