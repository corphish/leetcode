// https://leetcode.com/problems/find-all-groups-of-farmland
class Solution {
    public int[][] findFarmland(int[][] land) {
        int m = land.length, n = land[0].length;
        int group = 0;
        Map<Integer, TreeSet<Integer>> groups = new HashMap<>();
        boolean[][] grouped = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!grouped[i][j]) {
                    dfs(land, i, j, m, n, group++, groups, grouped);
                }
            }
        }

        int[][] res = new int[groups.size()][4];
        int k = 0;
        for (TreeSet<Integer> set: groups.values()) {
            int[] first = fromId(set.first(), n);
            int[] last = fromId(set.last(), n);

            res[k][0] = first[0];
            res[k][1] = first[1];
            res[k][2] = last[0];
            res[k][3] = last[1];

            k += 1;
        }

        return res;
    }

    int toId(int x, int y, int n) {
        return x * n + y;
    }

    int[] fromId(int id, int n) {
        return new int[] {
            id/n,
            id % n,
        };
    }

    void dfs(
        int[][] land,
        int i, int j,
        int m, int n,
        int groupId,
        Map<Integer, TreeSet<Integer>> groups,
        boolean[][] grouped
    ) {
        if (i < 0 || i >= m || j < 0 || j >= n) {
            return;
        }

        if (grouped[i][j]) {
            return;
        }

        if (land[i][j] == 0) {
            return;
        }

        grouped[i][j] = true;
        groups.computeIfAbsent(groupId, x -> new TreeSet<>()).add(toId(i, j, n));

        dfs(land, i + 1, j, m, n, groupId, groups, grouped);
        dfs(land, i - 1, j, m, n, groupId, groups, grouped);
        dfs(land, i, j + 1, m, n, groupId, groups, grouped);
        dfs(land, i, j - 1, m, n, groupId, groups, grouped);
    }
}