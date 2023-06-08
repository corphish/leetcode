// https://leetcode.com/problems/first-completely-painted-row-or-column
class Solution {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        Map<Integer, Integer> store = new HashMap<>();
        int m = mat.length, n = mat[0].length;
        int[] rows = new int[m];
        int[] cols = new int[n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                store.put(mat[i][j], i * n + j);
            }
        }

        for (int i = 0; i < arr.length; i++) {
            int ix = store.get(arr[i]);
            int x = ix/n;
            int y = ix % n;
            rows[x]++;
            cols[y]++;

            if (rows[x] == n || cols[y] == m) {
                return i;
            }
        }

        return -1;
    }
}