// https://leetcode.com/problems/pascals-triangle-ii
class Solution {
    public List<Integer> getRow(int n) {
        int[][] triangle = new int[n + 1][2 * n + 1];
        triangle[0][n] = 1;
        
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= 2 * n; j++) {
                triangle[i][j] = safeAccess(triangle, i - 1, j - 1) + safeAccess(triangle, i - 1, j + 1);
            }
        }
        
        /*for (int i = 0; i <= n; i++) {
            System.out.println(Arrays.toString(triangle[i]));
        }*/
        
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i <= 2 * n; i++) if (triangle[n][i] > 0) res.add(triangle[n][i]);
        
        return res;
    }
    
    int safeAccess(int[][] mat, int i, int j) {
        if (i < 0 || i >= mat.length) return 0;
        if (j < 0 || j >= mat[0].length) return 0;
        
        return mat[i][j];
    }
}