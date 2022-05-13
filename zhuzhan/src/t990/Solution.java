package t990;

/**
 * 990. 等式方程的可满足性
 * https://leetcode.cn/problems/satisfiability-of-equality-equations/
 * @author xzq
 * @create 2022-05-13-20:29
 */
class Solution {
    public boolean equationsPossible(String[] equations) {
        UnionFind unionFind = new UnionFind(30);
        for (String equation : equations) {
            if (equation.charAt(1) == '=') {
                unionFind.union(equation.charAt(0)-'a', equation.charAt(3)-'a');
            }
        }
        for (String equation : equations) {
            if (equation.charAt(1) == '!') {
                if (unionFind.connect(equation.charAt(0)-'a', equation.charAt(3)-'a')) {
                    return false;
                }
            }
        }
        return true;
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
        if (fx == fy) return;
        if (size[fx] > size[fy]) {
            int tmp = fx;
            fx = fy;
            fy = tmp;
        }
        father[fx] = fy;
        size[fy] += size[fx];
    }

    private int find(int x) {
        while (x != father[x]) {
            father[x] = father[father[x]];
            x = father[x];
        }
        return x;
    }

    public boolean connect(int x, int y) {
        return find(x) == find(y);
    }
}
// 通过   1 ms	40.7 MB