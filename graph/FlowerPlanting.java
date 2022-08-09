// https://leetcode.com/problems/flower-planting-with-no-adjacent
class Solution {
    public int[] gardenNoAdj(int n, int[][] paths) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        int[] types = new int[n];
        
        // Build undirected adj
        for (int[] path: paths) {
            adj.computeIfAbsent(path[0], k -> new ArrayList<>()).add(path[1]);
            adj.computeIfAbsent(path[1], k -> new ArrayList<>()).add(path[0]);
        }
        
        Set<Integer> visited = new HashSet<>();
        for (int i = 1; i <= n; i++) {
            // For each node, we will check their neighbors, and assign the first available color
            // If the color is not assigned, we have value as zero
            boolean[] nAvailable = new boolean[4];
            for (int x: adj.getOrDefault(i, new ArrayList<>())) {
                if (types[x - 1] != 0) {
                    nAvailable[types[x - 1] - 1] = true;
                }
            }
            
            for (int j = 0; j < 4; j++) {
                if (!nAvailable[j]) {
                    types[i - 1] = j + 1;
                    break;
                }
            }
            
        }
        
        return types;
    }
}