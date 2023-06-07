// https://leetcode.com/problems/matrix-diagonal-sum
class Solution {
    public int diagonalSum(int[][] mat) {
        int sum = 0;

        for (int i = 0; i < mat.length; i++) {
            sum += mat[i][i];
            if (mat.length - 1 - i != i)
                sum += mat[i][mat.length - 1 - i];
        }
        
        return sum;
    }
}