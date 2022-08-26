package t207;

import java.util.*;

/**
 * @title 207. 课程表
 * @link https://leetcode.cn/problems/course-schedule/
 * @from leetcode top 145
 * @author xzq
 * @create 2022-08-10-17:06
 */
// 拓扑排序，把入度为 0 的添加进队列，每次拿出入度为 0 的节点，将与这些节点相连的节点的入度都减一，若入度为 0 则入队
// 直到 队列为空，若所有节点都已删除，即所有节点入度都为 0，说明可以拓扑排序，否则不可以
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Deque<Integer> queue = new LinkedList<>();
        int[] inDegree = new int[numCourses];
        List<Integer>[] edges = new List[numCourses];
        for (int i = 0; i < numCourses; i++) {
            edges[i] = new ArrayList<>();
        }
        for (int[] prerequisite : prerequisites) {
            int u = prerequisite[1];
            int v = prerequisite[0];
            edges[u].add(v);
            inDegree[v]++;
        }
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            for (int i = 0; i < edges[curr].size(); i++) {
                int to = edges[curr].get(i);
                inDegree[to]--;
                if (inDegree[to] == 0) {
                    queue.offer(to);
                }
            }
        }
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] > 0) {
                return false;
            }
        }
        return true;
    }
}
// 通过   4 ms	41.9 MB