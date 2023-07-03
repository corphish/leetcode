// https://leetcode.com/problems/equal-row-and-column-pairs
class Solution {
    public int equalPairs(int[][] grid) {
        int n = grid.length, count = 0;
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            StringBuilder s = new StringBuilder();
            for (int j = 0; j < n; j++) {
                s.append(grid[i][j]).append(" ");
            }

            map.put(s.toString(), map.getOrDefault(s.toString(), 0) + 1);
        }

        for (int j = 0; j < n; j++) {
            StringBuilder s = new StringBuilder();
            for (int i = 0; i < n; i++) {
                s.append(grid[i][j]).append(" ");
            }

            if (map.containsKey(s.toString())) {
                count += map.get(s.toString());
            }
        }

        return count;
    }
}