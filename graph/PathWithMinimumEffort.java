// https://leetcode.com/problems/path-with-minimum-effort
class Solution {
    public int minimumEffortPath(int[][] heights) {
        int low = Integer.MAX_VALUE, high = Integer.MIN_VALUE;
        for (int[] row: heights) {
            for (int x: row) {
                low = Math.min(low, x);
                high = Math.max(high, x);
            }
        }

        boolean[][] visited = new boolean[heights.length][heights[0].length];
        int[][] memo = new int[heights.length][heights[0].length];

        if (check(heights, 0, 0, 0, visited, null)) {
            return 0;
        }

        int min = -1;
        while (low <= high) {
            for (int[] row: memo) Arrays.fill(row, 0);
            int mid = (low + high)/2;
            boolean res = check(heights, 0, 0, mid, visited, memo);

            if (res) {
                min = mid;
                high = mid - 1;
            } else {
                if (mid + 1 == min) {
                    break;
                }

                low = mid + 1;
            }
        }

        return min;
    }

    boolean check(
        int[][] graph,
        int i, int j, int k,
        boolean[][] visited,
        int[][] memo
    ) {
        if (i == graph.length - 1 && j == graph[0].length - 1) {
            return true;
        }

        if (visited[i][j]) {
            return false;
        }

        if (memo != null && memo[i][j] != 0) {
            return memo[i][j] == 1;
        }

        visited[i][j] = true;

        int left = Math.abs(safeGet(graph, i, j - 1) - graph[i][j]);
        int right = Math.abs(safeGet(graph, i, j + 1) - graph[i][j]);
        int top = Math.abs(safeGet(graph, i - 1, j) - graph[i][j]);
        int bottom = Math.abs(safeGet(graph, i + 1, j) - graph[i][j]);
        boolean res = false;

        if (!safeGet(visited, i, j - 1) && left <= k) {
            res |= check(graph, i, j - 1, k, visited, memo);
        }

        if (!res && !safeGet(visited, i, j + 1) && right <= k) {
            res |= check(graph, i, j + 1, k, visited, memo);
        }

        if (!res && !safeGet(visited, i - 1, j) && top <= k) {
            res |= check(graph, i - 1, j, k, visited, memo);
        }

        if (!res && !safeGet(visited, i + 1, j) && bottom <= k) {
            res |= check(graph, i + 1, j, k, visited, memo);
        }

        visited[i][j] = false;
        if (memo != null)
            memo[i][j] = res ? 1 : 2;
        return res;
    }

    int safeGet(int[][] mat, int i, int j) {
        return i >= mat.length || i < 0 || j >= mat[0].length || j < 0 ? Integer.MAX_VALUE : mat[i][j];
    }

    boolean safeGet(boolean[][] mat, int i, int j) {
        return i >= mat.length || i < 0 || j >= mat[0].length || j < 0 ? false : mat[i][j];
    }
}