package t332;

import java.util.*;

/**
 * 332. 重新安排行程
 * https://leetcode.cn/problems/reconstruct-itinerary/
 * @author xzq
 * @create 2022-05-31-8:25
 */
class Solution {

    private LinkedList<String> path;

    public List<String> findItinerary(List<List<String>> tickets) {
        path = new LinkedList<>();
        HashMap<String, TreeMap<String, Integer>> flight = new HashMap<>();
        for (List<String> ticket : tickets) {
            flight.putIfAbsent(ticket.get(0), new TreeMap<>());
            TreeMap<String, Integer> source = flight.get(ticket.get(0));
            source.put(ticket.get(1), source.getOrDefault(ticket.get(1), 0)+1);
        }
        path.addLast("JFK");
        backtrack(flight, tickets.size());
        return path;
    }

    private boolean backtrack(HashMap<String, TreeMap<String, Integer>> flight, int ticketNum) {
        if (path.size() == ticketNum+1) {
            return true;
        }
        TreeMap<String, Integer> targets = flight.get(path.getLast());
        if (targets == null) {
            return false;
        }
        for (Map.Entry<String, Integer> target : targets.entrySet()) {
            if (target.getValue() > 0) {
                target.setValue(target.getValue()-1);
                path.addLast(target.getKey());
                if (backtrack(flight, ticketNum)) {
                    return true;
                }
                path.removeLast();
                target.setValue(target.getValue()+1);
            }
        }
        return false;
    }
}
// 通过   7 ms	41.8 MB