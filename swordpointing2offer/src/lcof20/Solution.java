package lcof20;

import java.util.HashMap;
import java.util.Map;

/**
 * 剑指 Offer 20. 表示数值的字符串
 * https://leetcode-cn.com/problems/biao-shi-shu-zhi-de-zi-fu-chuan-lcof/
 * @author xzq
 * @create 2022-04-01-9:36
 */
public class Solution {
    public boolean isNumber(String s) {
        s = s.trim();
        Map<State, Map<CharLabel, State>> transfer = initTransfer();
        State nowState = State.START;
        for (int i = 0; i < s.length(); i++) {
            CharLabel nowCharLabel = getCharLabel(s.charAt(i));
            if (!transfer.get(nowState).containsKey(nowCharLabel)) return false;
            nowState = transfer.get(nowState).get(nowCharLabel);
        }
        return transfer.get(nowState).containsKey(CharLabel.TO_END);
    }
    private Map<State, Map<CharLabel, State>> initTransfer() {
        Map<State, Map<CharLabel, State>> transfer = new HashMap<State, Map<CharLabel, State>>();
        transfer.put(State.START, new HashMap<CharLabel, State>(){{
            put(CharLabel.NUMBER, State.INTEGER);
            put(CharLabel.PLUS_OR_MINUS, State.SIGN);
            put(CharLabel.POINT, State.DECIMAL_POINT_FRONT_NO_INTEGER);
        }});
        transfer.put(State.SIGN, new HashMap<CharLabel, State>(){{
            put(CharLabel.NUMBER, State.INTEGER);
            put(CharLabel.POINT, State.DECIMAL_POINT_FRONT_NO_INTEGER);
        }});
        transfer.put(State.INTEGER, new HashMap<CharLabel, State>(){{
            put(CharLabel.NUMBER, State.INTEGER);
            put(CharLabel.POINT, State.DECIMAL_POINT);
            put(CharLabel.CHAR_E, State.EXP_CHAR_E);
            put(CharLabel.TO_END, State.END);
        }});
        transfer.put(State.DECIMAL_POINT, new HashMap<CharLabel, State>(){{
            put(CharLabel.NUMBER, State.DECIMAL);
            put(CharLabel.CHAR_E, State.EXP_CHAR_E);
            put(CharLabel.TO_END, State.END);
        }});
        transfer.put(State.DECIMAL_POINT_FRONT_NO_INTEGER, new HashMap<CharLabel, State>(){{
            put(CharLabel.NUMBER, State.DECIMAL);
        }});
        transfer.put(State.DECIMAL, new HashMap<CharLabel, State>(){{
            put(CharLabel.NUMBER, State.DECIMAL);
            put(CharLabel.CHAR_E, State.EXP_CHAR_E);
            put(CharLabel.TO_END, State.END);
        }});
        transfer.put(State.EXP_CHAR_E, new HashMap<CharLabel, State>(){{
            put(CharLabel.PLUS_OR_MINUS, State.EXP_SIGN);
            put(CharLabel.NUMBER, State.EXP_INTEGER);
        }});
        transfer.put(State.EXP_SIGN, new HashMap<CharLabel, State>(){{
            put(CharLabel.NUMBER, State.EXP_INTEGER);
        }});
        transfer.put(State.EXP_INTEGER, new HashMap<CharLabel, State>(){{
            put(CharLabel.NUMBER, State.EXP_INTEGER);
            put(CharLabel.TO_END, State.END);
        }});
        return transfer;
    }
    private CharLabel getCharLabel(char c) {
        if (c == '+' || c == '-') return CharLabel.PLUS_OR_MINUS;
        if (c >= '0' && c <= '9') return CharLabel.NUMBER;
        if (c == '.') return CharLabel.POINT;
        if (c == 'e' || c == 'E') return CharLabel.CHAR_E;
        return CharLabel.UNKNOWN;
    }
    enum CharLabel {
        PLUS_OR_MINUS,
        NUMBER,
        POINT,
        CHAR_E,
        UNKNOWN,
        TO_END
    }
    enum State {
        START,
        SIGN,
        INTEGER,
        DECIMAL_POINT,
        DECIMAL_POINT_FRONT_NO_INTEGER,
        DECIMAL,
        EXP_CHAR_E,
        EXP_SIGN,
        EXP_INTEGER,
        END
    }
}