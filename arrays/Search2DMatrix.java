// https://leetcode.com/problems/search-a-2d-matrix
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int r = getRow(matrix, target);
        return r >= 0 && Arrays.binarySearch(matrix[r], target) >= 0;
    }
    
    int getRow(int[][] matrix, int target) {
        int n = matrix.length, m = matrix[0].length;
        int low = 0, high = n - 1;
        
        while (low <= high) {
            int mid = (low + high)/2;
            if (target >= matrix[mid][0] && target <= matrix[mid][m - 1]) {
                return mid;
            }
            if (target > matrix[mid][m - 1]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        
        return -1;
    }
}