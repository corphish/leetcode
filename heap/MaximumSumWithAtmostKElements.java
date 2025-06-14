// https://leetcode.com/problems/maximum-sum-with-at-most-k-elements/
class Solution {
    public long maxSum(int[][] grid, int[] limits, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < grid.length; i++) {
            Arrays.sort(grid[i]);
            for (int j = 0; j < limits[i]; j++) {
                heap.add(grid[i][grid[i].length - 1 - j]);
            }
        }

        long sum = 0;
        for (int i = 0; i < k; i++) {
            sum += heap.poll();
        }

        return sum;
    }
}