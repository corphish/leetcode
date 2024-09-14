// https://leetcode.com/problems/xor-queries-of-a-subarray/
class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int[] pfx = arr.clone();

        for (int i = 1; i < arr.length; i++) {
            pfx[i] = pfx[i - 1] ^ arr[i];
        }

        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            res[i] = queries[i][0] == 0 ? pfx[queries[i][1]] : pfx[queries[i][0] - 1] ^ pfx[queries[i][1]];
        }

        return res;
    }
}