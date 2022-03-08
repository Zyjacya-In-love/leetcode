package lcof2111;

import java.util.*;

/**
 * 剑指 Offer II 111. 计算除法
 * https://leetcode-cn.com/problems/vlzXQL/
 * @author xzq
 * @create 2022-03-08-10:08
 */
class Solution {
    private HashMap<String, Integer> equationId = new HashMap<>();
    private List<List<node>> eqEdge = new ArrayList<>();
    private int equationNum = 0;
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        for (int i = 0; i < values.length; i++) {
            addEqEdge(equations.get(i).get(0), equations.get(i).get(1), values[i]);
        }
        int n = queries.size();
        double[] ans = new double[n];
        Arrays.fill(ans, -1.0);
        nextQuery : for (int i = 0; i < n; i++) {
            List<String> query = queries.get(i);
            if (!equationId.containsKey(query.get(0)) || !equationId.containsKey(query.get(1))) {
                ans[i] = -1.0;
                continue;
            }
            if (query.get(0).equals(query.get(1))) {
                ans[i] = 1.0;
                continue;
            }
            int beginId = equationId.get(query.get(0));
            int endId = equationId.get(query.get(1));
            Deque<Integer> q = new LinkedList<>();
            q.offer(beginId);
            double[] dis = new double[equationNum];
            Arrays.fill(dis, -1.0);
            dis[beginId] = 1;
            while (!q.isEmpty()) {
                int now = q.poll();
                for (node neighbor : eqEdge.get(now)) {
                    if (dis[neighbor.id] == -1.0) {
                        if (neighbor.id == endId) {
                            ans[i] = dis[now] * neighbor.value;
                            continue nextQuery;
                        }
                        dis[neighbor.id] = dis[now] * neighbor.value;
                        q.offer(neighbor.id);
                    }
                }
            }
        }
        return ans;
    }
    public void addEqEdge(String equation1, String equation2, double value) {
        addEquation(equation1);
        addEquation(equation2);
        int id1 = equationId.get(equation1);
        int id2 = equationId.get(equation2);
        eqEdge.get(id1).add(new node(id2, value));
        eqEdge.get(id2).add(new node(id1, 1/value));
    }
    public void addEquation(String equation) {
        if (!equationId.containsKey(equation)) {
            equationId.put(equation, equationNum++);
            eqEdge.add(new ArrayList<>());
        }
    }
    private class node {
        int id;
        double value;
        node(int id, double value) {
            this.id = id;
            this.value = value;
        }
    }
}
