// https://leetcode.com/problems/reconstruct-itinerary
class Solution {
    List<String> res;
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, Integer> indexMap = buildIndexMap(tickets);
        String[] nodePositions = invertIndexMap(indexMap);
        int nodes = indexMap.size();
        int edges = tickets.size();
        int[][] adj = new int[nodes][nodes];

        for (var ticket: tickets) {
            String from = ticket.get(0);
            String to = ticket.get(1);

            adj[indexMap.get(from)][indexMap.get(to)] += 1;
        }

        build(indexMap, nodePositions, adj, "JFK", edges, new Stack<>());
        return res;
    }

    boolean build(
        Map<String, Integer> indexMap,
        String[] nodePositions,
        int[][] adj,
        String curr,
        int edges,
        Stack<String> path
    ) {
        path.push(curr);

        if (edges == 0) {
            if (res == null) {
                res = new ArrayList<>(path);
            }

            return true;
        }
        
        int pos = indexMap.get(curr);
        boolean r = false;
        for (int i = 0; i < adj[pos].length; i++) {
            if (adj[pos][i] > 0) {
                adj[pos][i] -= 1;
                r |= build(indexMap, nodePositions, adj, nodePositions[i], edges - 1, path);
                adj[pos][i] += 1;

                if (r) {
                    break;
                }
            }
        }

        path.pop();
        return r;
    }

    Map<String, Integer> buildIndexMap(List<List<String>> tickets) {
        Set<String> set = new TreeSet<>();
        Map<String, Integer> map = new HashMap<>();

        for (var e: tickets) {
            for (var x: e) {
                set.add(x);
            }
        }

        int i = 0;
        for (String x: set) {
            map.put(x, i++);
        }

        return map;
    }

    String[] invertIndexMap(Map<String, Integer> map) {
        String[] res = new String[map.size()];
        for (var e: map.entrySet()) {
            res[e.getValue()] = e.getKey();
        }

        return res;
    }
}