// https://leetcode.com/problems/number-of-adjacent-elements-with-the-same-color/
class Solution {
    public int[] colorTheArray(int n, int[][] queries) {
        int[] arr = new int[n];
        int adj = 0;
        int[] res = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int idx = queries[i][0];
            int prev = idx > 0 ? arr[idx - 1] : -1;
            int next = idx < n - 1 ? arr[idx + 1] : -1;

            if (arr[idx] == prev && arr[idx] != 0) {
                adj -= 1;
            } 

            if (arr[idx] == next && arr[idx] != 0) {
                adj -= 1;
            }

            arr[idx] = queries[i][1];

            if (arr[idx] == prev && arr[idx] != 0) {
                adj += 1;
            } 

            if (arr[idx] == next && arr[idx] != 0) {
                adj += 1;
            }

            res[i] = adj;
        }

        return res;
    }
}