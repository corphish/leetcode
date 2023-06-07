// https://leetcode.com/problems/minimum-cost-to-cut-a-stick/
class Solution {
    public int minCost(int n, int[] cuts) {
        boolean[] v = new boolean[cuts.length];
        Map<Long, Integer> memo = new HashMap<>();
        return min(cuts, 0, n, v, memo);
    }

    int min(int[] cuts, int start, int end, boolean[] visited, Map<Long, Integer> memo) {
        int score = 0;
        long key = start * 10000000 + end;
        if (memo.containsKey(key)) return memo.get(key);
        for (int i = 0; i < cuts.length; i++) {
            if (!visited[i] && cuts[i] > start && cuts[i] < end) {
                visited[i] = true;
                if (score == 0) {
                    score = (end - start) + min(cuts, start, cuts[i], visited, memo) + min(cuts, cuts[i], end, visited, memo);
                } else {
                    score = Math.min(score, (end - start) + min(cuts, start, cuts[i], visited, memo) + min(cuts, cuts[i], end, visited, memo));
                }
                
                visited[i] = false;
            }
        }

        memo.put(key, score);

        return score;
    }
}