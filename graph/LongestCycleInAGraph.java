// https://leetcode.com/problems/longest-cycle-in-a-graph/
class Solution {
    public int longestCycle(int[] edges) {
        Set<Integer> cyclicNodes = new HashSet<>();
        int max = -1;

        for (int i = 0; i < edges.length; i++) {
            if (cyclicNodes.contains(i)) {
                continue;
            }
            Set<Integer> set = dfs(edges, i, cyclicNodes);
            if (set != null) {
                cyclicNodes.addAll(set);
                max = Math.max(max, set.size());
            } else {
            }
        }

        return max;
    }

    Set<Integer> dfs(int[] edges, int src, Set<Integer> visited) {
        Set<Integer> session = new HashSet<>();
        int start = src;
        while (!session.contains(start)) {
            if (visited.contains(start)) {
                return null;
            }
            session.add(start);
            start = edges[start];
            if (start == -1) {
                return null;
            }
        }

        // So there is a cycle which involves start
        // Re traverse to get the cycle only
        session.clear();
        while (!session.contains(start)) {
            session.add(start);
            start = edges[start];
        }

        return session;
    }
}