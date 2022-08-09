//https://leetcode.com/problems/search-a-2d-matrix-ii/
class Solution {
    // For each row, we check the possibility of the target, and then do a binary search
    public boolean searchMatrix(int[][] matrix, int target) {
        /*for (int[] arr: matrix) {
            if (target >= arr[0] && target <= arr[arr.length - 1] && Arrays.binarySearch(arr, target) >= 0) {
                return true;
            }
        }*/
        
        return search(matrix, target, 0, matrix.length - 1);
    }
    
    boolean search(int[][] arr, int target, int l, int r) {
        if (l > r) {
            return false;
        }
        
        int mid = (l + r)/2;
        //System.out.println("Searching in arr index " + mid);
        if (target >= arr[mid][0] && target <= arr[mid][arr[mid].length - 1]) {
            if (Arrays.binarySearch(arr[mid],target) >= 0) {
                return true;
            }
        }
        
        if (mid < arr.length - 1) {
            if (target >= arr[mid + 1][0] && target <= arr[mid + 1][arr[mid].length - 1]) {
                if (search(arr, target, mid + 1, r)) {
                    return true;
                }
            }
        }
        
        if (mid > 0) {
            if (target >= arr[mid - 1][0] && target <= arr[mid - 1][arr[mid].length - 1]) {
                if (search(arr, target, l, mid - 1)) {
                    return true;
                }
            }
        }
        
        if (target < arr[mid][0]) {
            return search(arr, target, l, mid - 1);
        } else {
            return search(arr, target, mid + 1, r);
        }
    }
}