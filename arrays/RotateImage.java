// https://leetcode.com/problems/rotate-image/submissions/
class Solution {
    public void rotate(int[][] matrix) {
        rec(matrix, 0, 0, matrix.length);
    }
    
    // For each outer portion of the array, we do the following swaps
    // (i, j) - > (j, n - 1 - i)
    // (j, n - 1 - i) - > (n - 1 - i, n - 1 - j)
    // (n - 1 - i, n - 1 - j) -> (n - 1 - j, i)
    // (n - 1 - j, i) -> (i, j)
    // We recursively call it for i + 1, j + 1 while i < n/2
    void rec(int[][] matrix, int i, int j, int n) {
        if (i >= n/2) {
            return;
        }
        
        int t1, t2, k = j;
        
        for (; j < n - 1 - i; j++) {
            // Swap (i, j) -> (j, n - 1 - i)
            t1 = matrix[i][j];
            t2 = matrix[j][n - 1 - i];
            matrix[j][n - 1 - i] = t1;
            
            // Swap (j, n - 1 - i) - > (n - 1 - i, n - 1 - j)
            t1 = t2;
            t2 = matrix[n - 1 - i][n - 1 - j];
            matrix[n - 1 - i][n - 1 - j] = t1;
            
            // Swap (n - 1 - i, n - 1 - j) - > (n - 1 - j, i)
            t1 = t2;
            t2 = matrix[n - 1 - j][i];
            matrix[n - 1 - j][i] = t1;
            
            // Swap (n - 1 - j, i) - > (i, j)
            t1 = t2;
            t2 = matrix[i][j];
            matrix[i][j] = t1;
            
            //System.out.println(t1 + " " + t2);
            //print(matrix);
        }
        
        rec(matrix, i + 1, k + 1, n);
    }
}