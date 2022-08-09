// https://leetcode.com/problems/ways-to-make-a-fair-array
class Solution {
    public int waysToMakeFair(int[] nums) {
        // [6, 1, 7, 4, 1], odd = 5, even = 14
        // odd = [0, 1, 1, 5, 5]
        // even = [6, 6, 13, 13, 14]
        
        // Removing an odd index (1)
        // [6, 7, 4, 1]
        // odd = [0, 7, 7, 8]
        // even = [6, 6, 10, 10]
        // odd sum = odd[i - 1] + (even[n - 1] - even[i])
        // even sum = even[i - 1] + (odd[n - 1] - odd[i])
        
        // Removing even index (2)
        // [6, 1, 4, 1]
        // odd = [0, 1, 1, 2]
        // even = [6, 6, 10, 10]
        // Formulas hold true foreven removal
        
        if (nums.length == 1) {
            return 1;
        }
        
        int[] odd = new int[nums.length];
        int[] even = new int[nums.length];
        int count = 0;
        
        even[0] = nums[0];
        for (int i = 2; i < nums.length; i += 2) {
            even[i] = even[i - 2] + nums[i];
        }
        
        odd[1] = nums[1];
        for (int i = 3; i < nums.length; i += 2) {
            odd[i] = odd[i - 2] + nums[i];
        }
        
        
        // System.out.println("Odd = " + Arrays.toString(odd));
        // System.out.println("Even = " + Arrays.toString(even));
        
        for (int i = 1; i < nums.length; i++) {
            if (even[i] == 0) {
                even[i] = even[i - 1];
            }
            
            if (odd[i] == 0) {
                odd[i] = odd[i - 1];
            }
        }
        
        // We are going to remove ith element and see if array is fair or not
        for (int i = 0; i < nums.length; i++) {
            int oddSum = (i == 0 ? 0 : odd[i - 1]) + (even[nums.length - 1] - even[i]);
            int evenSum = (i == 0 ? 0 : even[i - 1]) + (odd[nums.length - 1] - odd[i]);
            
            // System.out.printf("After removing %d, oddSum = %d, evenSum = %d\n", i, oddSum, evenSum);
            
            if (oddSum == evenSum) {
                count++;
            }
        }
        
        return count;
    } 
}