package t118;

import java.util.ArrayList;
import java.util.List;

/**
 * 118. 杨辉三角
 * https://leetcode-cn.com/problems/pascals-triangle/
 * @author xzq
 * @create 2022-04-25-10:51
 */
class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            ans.add(new ArrayList<>());
        }
        ans.get(0).add(1);
        for (int i = 1; i < numRows; i++) {
            ans.get(i).add(1);
            for (int j = 0; j < i-1; j++) {
                ans.get(i).add(ans.get(i-1).get(j)+ans.get(i-1).get(j+1));
            }
            ans.get(i).add(1);
        }
        return ans;
    }
}