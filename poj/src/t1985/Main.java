package t1985;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * POJ 1985 Cow Marathon
 * http://poj.org/problem?id=1985
 * @author xzq
 * @create 2022-03-16-8:44
 */
public class Main {
    public static void main(String[] args) {
        new Main().solve();
    }
    private List<List<node>> edge;
    private int maxDistance = 0;
    private boolean[] vis;
    private void solve() {
//        try {
//            File f = new File("poj/t.txt");
//            System.setIn(new FileInputStream(f));
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
        Scanner scan = new Scanner(new BufferedInputStream(System.in));
        int N = scan.nextInt();
        int M = scan.nextInt();
        initGraph(N);
        for (int i = 0; i < M; i++) {
            int u = scan.nextInt();
            int v = scan.nextInt();
            int c = scan.nextInt();
            String d = scan.next();
            addEdge(u,v,c);
        }

//        for (List<node> x : edge) {
//            System.out.println(x);
//        }

        vis = new boolean[N+1];
        dfs(1);
        System.out.println(maxDistance);
    }
    private int dfs(int s) {
        vis[s] = true;
        int firstMaxDepth = 0;
        int secondMaxDepth = 0;
        for (node child : edge.get(s)) {
            if (vis[child.to]) continue;
            int nowDepth = dfs(child.to) + child.cost;
            if (nowDepth > firstMaxDepth) {
                secondMaxDepth = firstMaxDepth;
                firstMaxDepth = nowDepth;
            } else if (nowDepth > secondMaxDepth) {
                secondMaxDepth = nowDepth;
            }
        }
//        System.out.println("s : " + s);
//        System.out.println("firstMaxDepth : " + firstMaxDepth);
//        System.out.println("secondMaxDepth : " + secondMaxDepth);
        maxDistance = Math.max(maxDistance, firstMaxDepth+secondMaxDepth);
//        System.out.println("maxDistance : " + maxDistance);
        return Math.max(firstMaxDepth, secondMaxDepth);
    }
    private void initGraph(int N) {
        edge = new ArrayList<List<node>>();
        for (int i = 0; i <= N; i++) {
            edge.add(new ArrayList<node>());
        }
    }
    private void addEdge(int u, int v, int c) {
        edge.get(u).add(new node(v, c));
        edge.get(v).add(new node(u, c));
    }
    private class node {
        int to, cost;
        node(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
        @Override
        public String toString() {
            return "node{" +
                    "to=" + to +
                    ", cost=" + cost +
                    '}';
        }
    }
}
