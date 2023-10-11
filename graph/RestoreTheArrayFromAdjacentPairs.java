// https://leetcode.com/problems/restore-the-array-from-adjacent-pairs/
class Solution {
    public int[] restoreArray(int[][] adjacentPairs) {
        Map<Integer, Set<Integer>> adj = new HashMap<>();
        for (int[] p: adjacentPairs) {
            adj.computeIfAbsent(p[0], x -> new HashSet<>()).add(p[1]);
            adj.computeIfAbsent(p[1], x -> new HashSet<>()).add(p[0]);
        }

        int[] res = new int[adjacentPairs.length + 1];
        int el = 0;
        for (var e: adj.entrySet()) {
            if (e.getValue().size() == 1) {
                form(adj, e.getKey(), res, 0, new HashSet<>());
                break;
            }
        }

        return res;
    }

    void form(Map<Integer, Set<Integer>> adj, int el, int[] res, int pos, Set<Integer> used) {
        if (pos >= res.length) {
            return;
        }

        res[pos] = el;
        used.add(el);

        for (int x: adj.get(el)) {
            if (x != el && !used.contains(x)) {
                form(adj, x, res, pos + 1, used);
            }
        }
    }
}