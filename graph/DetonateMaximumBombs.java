// https://leetcode.com/problems/detonate-the-maximum-bombs
class Solution {
    public int maximumDetonation(int[][] bombs) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        
        for (int i = 0; i < bombs.length; i++) {
            for (int j = 0; j < bombs.length; j++) {
                if (i != j && isWithinRange(bombs[i], bombs[j])) {
                    adj.computeIfAbsent(i, k -> new ArrayList<>()).add(j);
                }
            }
        }
        
        // Result will be longest path that can be traversed from any node
        int max = 0;
        for (int i = 0; i < bombs.length; i++) {
            Set<Integer> visited = new HashSet<>();
            dfs(adj, i, visited);
            max = Math.max(max, visited.size());
        }
        
        return max;
    }
    
    void dfs(Map<Integer, List<Integer>> adj, int curr, Set<Integer> visited) {
        if (visited.contains(curr)) {
            return;
        }
        
        visited.add(curr);
        
        for (int x: adj.getOrDefault(curr, List.of())) {
            dfs(adj, x, visited);
        }
    }
    
    boolean isWithinRange(int[] c1, int[] c2) {
        return isWithinRange(c1[0], c1[1], c1[2], c2[0], c2[1], c2[2]);
    }
    
    // Range should be distance between 2 centers should be less than the radius of the detonating bomb.
    boolean isWithinRange(int x1, int y1, int r1, int x2, int y2, int r2) {
        return Math.sqrt(
            Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2) 
        ) <= r1;
    }
}