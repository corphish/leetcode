// https://leetcode.com/problems/build-a-matrix-with-conditions/
class Solution {
    public int[][] buildMatrix(int k, int[][] row, int[][] col) {
        int[][] res = new int[k][k];

        Map<Integer, List<Integer>> rowAdj = new HashMap<>();
        Map<Integer, List<Integer>> colAdj = new HashMap<>();

        for (int[] r : row) {
            rowAdj.computeIfAbsent(r[1], x -> new ArrayList<>()).add(r[0]);
        }

        for (int[] c : col) {
            colAdj.computeIfAbsent(c[1], x -> new ArrayList<>()).add(c[0]);
        }

        Stack<Integer> rowSorted = topologicalSort(rowAdj, k);
        Stack<Integer> colSorted = topologicalSort(colAdj, k);

        List<Integer> rowList = new ArrayList<>(rowSorted);
        List<Integer> colList = new ArrayList<>(colSorted);

        if (hasCycle(rowAdj, rowSorted, k)) {
            return new int[][] {};
        }

        if (hasCycle(colAdj, colSorted, k)) {
            return new int[][] {};
        }

        for (int i = 1; i <= k; i++) {
            res[rowList.indexOf(i)][colList.indexOf(i)] = i;
        }

        return res;
    }

    void dfs(Map<Integer, List<Integer>> adj, int v, boolean[] visited, Stack<Integer> stack) {
        visited[v] = true;

        for (int x : adj.getOrDefault(v, List.of())) {
            if (!visited[x]) {
                dfs(adj, x, visited, stack);
            }
        }

        stack.push(v);
    }

    Stack<Integer> topologicalSort(Map<Integer, List<Integer>> adj, int n) {
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[n + 1];

        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                dfs(adj, i, visited, stack);
            }
        }

        return stack;
    }

    boolean hasCycle(Map<Integer, List<Integer>> adj, Stack<Integer> sorted, int n) {
        Map<Integer, Integer> pos = new HashMap<>();
        int idx = 0;
        while (!sorted.isEmpty()) {
            pos.put(sorted.pop(), idx++);
        }

        // System.out.println(pos);

        for (int i = 1; i <= n; i++) {
            // System.out.println("Checking " + i + ", neighbors = " + adj.get(i));
            for (int j : adj.getOrDefault(i, List.of())) {
                if (pos.get(i) > pos.get(j)) {
                    // System.out.println("Cycle found for " + i + " and " + j);
                    return true;
                }
            }
        }

        return false;
    }
}