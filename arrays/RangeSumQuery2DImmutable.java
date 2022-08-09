// https://leetcode.com/problems/range-sum-query-2d-immutable/
class NumMatrix {
    
    int[][] matrix;
    
    // [[3, 3, 4, 8, 10], 
    //  [5, 11, 14, 16, 17], 
    //  [1, 3, 3, 4, 9], 
    //  [4, 5, 5, 6, 13], 
    //  [1, 1, 4, 4, 9]]
    
    // Calculate prefix sum of each row, and for each row, return sum calculation for each row in the range.
    

    public NumMatrix(int[][] matrix) {
        this.matrix = matrix;
        
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                matrix[i][j] += matrix[i][j - 1];
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = 0;
        
        for (int i = row1; i <= row2; i++) {
            sum += col1 == 0 ? matrix[i][col2] : matrix[i][col2] - matrix[i][col1 - 1];
        }
        
        return sum;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */