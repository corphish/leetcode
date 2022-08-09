class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // [2, 3, 4, 0, 0], first = 2, end = 4
        // [1, 2] second = 1 
        
        // [2, 3, 0, 0, 4], first = 1, end = 3
        // [1, 2] second = 1
        
        // [2, 0, 0, 3, 4] first = 0, end = 2
        // [1, 2] second = 1
        
        // [2, 0, 2, 3, 4], first = 0, end = 1
        // [1, 2] second = 0
        
        // [0, 2, 2, 3, 4], first = -1, end = 0
        // [1, 2] second = 0
        
        // [1, 2, 2, 3, 4], first = -1, end = 0
        // [1, 2] second = -1
        
        // [1, 2, 0, 0]
        // [4, 5]
        
        // Logic, start from the end, swap if the nums1 pointer has higher value and send it to end
        // Assign and remove 0 in nums1 with nums2 value if nusm2 value is more
        
        int first = m - 1, second = n - 1, end = (m + n) - 1;
        
        while (second != -1) {
            if (first == -1) {
                // We populate the remaining values of nums2
                nums1[end--] = nums2[second--];
            } else if (second == -1) {
                // When this happens, array is already sorted
            } else {
                if (nums2[second] > nums1[first]) {
                    nums1[end--] = nums2[second--];
                } else {
                    // Swap
                    int t = nums1[first];
                    nums1[first] = nums1[end];
                    nums1[end] = t;
                    
                    first--;
                    end--;
                }
            }
        }
    }
}