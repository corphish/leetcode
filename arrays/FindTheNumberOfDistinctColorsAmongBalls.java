// https://leetcode.com/problems/find-the-number-of-distinct-colors-among-the-balls
class Solution {
    public int[] queryResults(int limit, int[][] queries) {
        Map<Integer, Integer> map = new HashMap<>();
        Map<Integer, Set<Integer>> rev = new HashMap<>();
        int[] res = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int curr = map.getOrDefault(queries[i][0], -1);
            
            if (curr != -1) {
                Set<Integer> set = rev.get(curr);
                set.remove(queries[i][0]);
                if (set.isEmpty()) {
                    rev.remove(curr);
                }
            }

            map.put(queries[i][0], queries[i][1]);
            rev.computeIfAbsent(queries[i][1], x -> new HashSet<>()).add(queries[i][0]);

            res[i] = rev.size();
        }

        return res;
    }
}