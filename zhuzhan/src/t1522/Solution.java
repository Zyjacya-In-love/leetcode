package t1522;

import java.util.*;

/**
 * @title 1522. N 叉树的直径（会员题）
 * @link https://leetcode.cn/problems/diameter-of-n-ary-tree/
 * @from my unity exam 1006 2t
 * @author xzq
 * @create 2022-10-06-20:25
 */

// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;


    public Node() {
        children = new ArrayList<Node>();
    }

    public Node(int _val) {
        val = _val;
        children = new ArrayList<Node>();
    }

    public Node(int _val,ArrayList<Node> _children) {
        val = _val;
        children = _children;
    }
}

// 方法一：两次 BFS，一次 BFS 得到的最远点必然是直径的一个端点，然后再第二次 BFS 从直径的一端出发即可达到直径的另一端获得直径的长度
// 证明：https://blog.csdn.net/Krone_/article/details/99301213?ops_request_misc=%257B%2522request%255Fid%2522%253A%2522166506176416782428695835%2522%252C%2522scm%2522%253A%252220140713.130102334.pc%255Fblog.%2522%257D&request_id=166506176416782428695835&biz_id=0&utm_medium=distribute.pc_search_result.none-task-blog-2~blog~first_rank_ecpm_v1~rank_v31_ecpm-1-99301213-null-null.nonecase&utm_term=%E6%A0%91%E7%9A%84%E7%9B%B4%E5%BE%84&spm=1018.2226.3001.4450
// 这题的输入其实不太适合用这种办法，这里是 节点重新编号+建图 再两遍 bfs，麻烦了很多
//class Solution {
//    public int diameter(Node root) {
//        if (root == null) {
//            return 0;
//        }
//        int n = 10100; // error 2：看错了，把最大深度看成节点最大总数了，节点的总个数在 [0, 10^4] 间。
//        edges = new ArrayList[n];
//        for (int i = 0; i < n; i++) {
//            edges[i] = new ArrayList<>();
//        }
//        Deque<Node> queue = new LinkedList<>();
//        queue.offer(root);
//        Map<Node, Integer> map = new HashMap<>(); // error 1：树中节点的val可能会有重复，这里重新标号解决这一问题
//        int cnt = 0;
//        map.put(root, cnt++);
//        while (!queue.isEmpty()) {
//            Node curr = queue.poll();
//            int u = map.get(curr);
//            for (Node nei : curr.children) {
//                queue.offer(nei);
//                int v = cnt;
//                map.put(nei, cnt++);
//                addEdge(u, v);
//                addEdge(v, u);
//            }
//        }
//        dist = new int[n];
//        vis = new boolean[n];
//        return dist[bfs(bfs(0))]; // error 1：这里重新编号之后根节点是 0，0 一定存在
//    }
//
//    ArrayList<Integer>[] edges;
//    int[] dist;
//    boolean[] vis; // 必须得有 vis，因为相当于把树看成是 无向图，所有还可以连回去，产生回路，所以必须判断有没有访问过，避免重复访问，产生死循环
//
//    private int bfs(int s) {
//        Arrays.fill(dist, 0);
//        Arrays.fill(vis, false);
//        int maxDist = 0;
//        int maxIdx = s;
//        Deque<Integer> queue = new LinkedList<>();
//        queue.offer(s);
//        dist[s] = 0;
//        vis[s] = true;
//        while (!queue.isEmpty()) {
//            int curr = queue.poll();
//            if (dist[curr] > maxDist) {
//                maxIdx = curr;
//                maxDist = dist[curr];
//            }
//            for (int v : edges[curr]) {
//                if (!vis[v]) {
//                    vis[v] = true;
//                    queue.offer(v);
//                    dist[v] = dist[curr] + 1;
//                }
//            }
//        }
//        return maxIdx;
//    }
//
//    private void addEdge(int u, int v) {
//        edges[u].add(v);
//    }
//}
// 通过   14 ms	43 MB


// 方法二：dfs 的同时记录当前节点向下搜索的最大的两个深度，以当前节点为根的树并且包含当前节点的最长路即是最大的两个深度之和，
// dfs的同时记录所有以当前节点为根的树并且包含当前节点的最长路的最大者即是树的最长路
// 这里就不需要 vis，因为这里是 dfs的树，树没有回路，只会向下延申，不会产生再一次访问访问过的节点而造成的死循环
class Solution {

    private int maxDistance = 0;

    public int diameter(Node root) {
        dfs(root);
        return maxDistance;
    }

    private int dfs(Node root) {
        int firstMaxDepth = 0;
        int secondMaxDepth = 0;
        for (Node nei : root.children) {
            int nowDepth = dfs(nei) + 1;
            if (nowDepth > firstMaxDepth) {
                secondMaxDepth = firstMaxDepth;
                firstMaxDepth = nowDepth;
            } else if (nowDepth > secondMaxDepth) {
                secondMaxDepth = nowDepth;
            }
        }
        maxDistance = Math.max(maxDistance, firstMaxDepth+secondMaxDepth);
        return firstMaxDepth;
    }
}
// 通过   0 ms	41.3 MB