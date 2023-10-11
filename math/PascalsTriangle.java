// https://leetcode.com/problems/pascals-triangle
class Solution {
    public List<List<Integer>> generate(int n) {
        int[][] arr = new int[n][2 * n];
        int start = n;
        arr[0][start] = 1;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                int index = start - i + (2 * j);
                arr[i][index] = safeAccess(arr, i - 1, index - 1) + safeAccess(arr, i - 1, index + 1);
            }
        }
        
        List<List<Integer>> res = new ArrayList<>();
        for (int[] A: arr) {
            List<Integer> row = new ArrayList<>();
            for (int x: A) if (x != 0) row.add(x);
            res.add(row);
        }
        
        return res;        
    }
    
    private int safeAccess(int[][] arr, int i, int j) {
        if (i < 0 || i >= arr.length || j < 0 || j >= arr[0].length) return 0;
        return arr[i][j];
    }
}