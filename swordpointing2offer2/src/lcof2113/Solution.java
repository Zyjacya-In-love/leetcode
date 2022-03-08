package lcof2113;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 剑指 Offer II 113. 课程顺序
 * https://leetcode-cn.com/problems/QA2IGt/
 * @author xzq
 * @create 2022-03-08-10:09
 */
class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if (numCourses == 1) return new int[]{0};
        List<List<Integer>> edge = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            edge.add(new ArrayList<>());
        }
        int[] inDegree = new int[numCourses];
        for (int[] prerequisite : prerequisites) {
            int a = prerequisite[0];
            int b = prerequisite[1];
            edge.get(b).add(a);
            inDegree[a]++;
        }
        Deque<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                q.offer(i);
            }
        }
        int idx = 0;
        int[] ans = new int[numCourses];
        while (!q.isEmpty()) {
            int now = q.poll();
            ans[idx++] = now;
            for (int neighbor : edge.get(now)) {
                inDegree[neighbor]--;
                if (inDegree[neighbor] == 0) {
                    q.offer(neighbor);
                }
            }
        }
        if (idx == numCourses) {
            return ans;
        }
        return new int[0];
    }

}
