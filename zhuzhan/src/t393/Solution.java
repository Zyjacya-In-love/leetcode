package t393;

/**
 * 393. UTF-8 编码验证
 * https://leetcode-cn.com/problems/utf-8-validation/
 * @author xzq
 * @create 2022-03-13-11:27
 */
public class Solution {
    public boolean validUtf8(int[] data) {
        int byte10000000 = 1<<7;
        int cnt = 1;
        for (int i = 0; i < data.length; i+=cnt) {
            cnt = 0;
            while ((byte10000000 & data[i]) > 0) {
                data[i] <<= 1;
                cnt++;
            }
            if (cnt == 0) {
                cnt++;
                continue;
            }
            if (cnt == 1 || cnt > 4 || data.length-i-cnt < 0) return false;
            for (int j = 1; j < cnt; j++) {
                if ((data[i+j]>>6) != 2) return false;
            }
        }
        return true;
    }
}
