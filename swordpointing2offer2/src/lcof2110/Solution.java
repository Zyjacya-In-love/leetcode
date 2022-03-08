package lcof2110;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 剑指 Offer II 110. 所有路径
 * https://leetcode-cn.com/problems/bP4bmD/
 * @author xzq
 * @create 2022-03-08-10:07
 */
class Solution {
    List<List<Integer>> path;
    public void dfs(int s, int[][] graph, List<Integer> tmp) {
        if (s == graph.length-1) {
            path.add(new ArrayList<>(tmp));
            return;
        }
        for (int i = 0; i < graph[s].length; i++) {
            tmp.add(graph[s][i]);
            dfs(graph[s][i], graph, tmp);
            tmp.remove(tmp.size()-1);
        }
    }
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        path = new ArrayList<>();
        dfs(0, graph, new ArrayList<>(Arrays.asList(0)));
        return path;
    }
}
