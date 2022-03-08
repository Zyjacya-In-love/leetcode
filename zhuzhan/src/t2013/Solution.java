package t2013;

import java.util.HashMap;

/**
 * 2013. 检测正方形
 * https://leetcode-cn.com/problems/detect-squares/
 * @author xzq
 * @create 2022-03-08-10:18
 */
class Solution {
    class DetectSquares {
        private HashMap<Integer, HashMap<Integer, Integer>> mp;

        public DetectSquares() {
            mp = new HashMap<>();
        }

        public void add(int[] point) {
            mp.putIfAbsent(point[0], new HashMap<>());
            mp.get(point[0]).put(point[1], mp.get(point[0]).getOrDefault(point[1], 0)+1);
        }

        public int count(int[] point) {
//            System.out.println("count()");
//            System.out.println("point : " + point[0] + " " + point[1]);
//            System.out.println("mp : " + mp.toString());
            if (!mp.containsKey(point[0])) return 0;
            int res = 0;
            for (Integer y : mp.get(point[0]).keySet()) {
                if (y == point[1]) continue;
                int tmp = 0;
                int len = Math.abs(y-point[1]);
                if (mp.containsKey(point[0]+len)) {
                    if (mp.get(point[0]+len).containsKey(point[1]) && mp.get(point[0]+len).containsKey(y))
                        tmp += (mp.get(point[0]+len).get(point[1])*mp.get(point[0]+len).get(y));
                }
                if (mp.containsKey(point[0]-len)) {
                    if (mp.get(point[0]-len).containsKey(point[1]) && mp.get(point[0]-len).containsKey(y))
                        tmp += (mp.get(point[0]-len).get(point[1])*mp.get(point[0]-len).get(y));
                }
                res += (tmp*mp.get(point[0]).get(y));
            }
            return res;
        }
    }
}
