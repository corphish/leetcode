// https://leetcode.com/problems/peak-index-in-a-mountain-array
class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int l = 0, r = arr.length - 1;
        
        while (l <= r) {
            int mid = (l + r)/2;
            
            if (mid == 0 || mid == arr.length - 1) {
                return mid;
            }
            
            if (arr[mid] > arr[mid + 1] && arr[mid] > arr[mid - 1]) {
                return mid;
            }
            
            if (arr[mid] < arr[mid + 1]) {
                l = mid;
            } else {
                r = mid;
            }
        }
        
        return 0;
    }
}