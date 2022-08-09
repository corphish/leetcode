// Question : Given an array, rotate the array to the right by k steps, where k is non-negative.
// We can solve this in many ways:
// 1. We can create a new array and put newArray[k % n] = nums[i]. This will have O(n) time and space.
// 2. Better solution is to perform a series of reversals.
// 3. We first reverse the entire array. Then we reverse the first k elements of the array, and then the rest to 
//    have the answer. This takes only O(n) time and constant space.
class Solution {
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        int n = nums.length;
        
        reverse(nums, 0, n - 1);
        
        reverse(nums, 0, k - 1);
        reverse(nums, k, n - 1);
        
        // [1, 2, 3, 4, 5], k = 2
        // Expected result = [4, 5, 1, 2, 3]
        // Reversal 1 (full reverse) = [5, 4, 3, 2, 1]
        // Reversal 2 (from 0..k-1) = [4, 5, 3, 2, 1]
        // Reversal 4 (from k..n-1) = [4, 5, 1, 2, 3]
    }
    
    // Reverses the portion of array between i and j indexes (inclusive)
    void reverse(int[] arr, int i, int j) {
        while (i <= j) {
            int t = arr[i];
            arr[i] = arr[j];
            arr[j] = t;
            
            i++;
            j--;
        }
    }
}