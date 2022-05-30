// https://leetcode.com/problems/house-robber-ii
class Solution {
    // Use dp to find the max money that can be robbed.
    // 1. From house[0] to house[n-2]
    // 2. From house[1] to house[n-1]
    // Return the max of both
    public int rob(int[] nums) {
        //System.out.println("New");
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);
        
        int n = nums.length;
        
        int[] dp1 = new int[n - 1];
        dp1[0] = nums[0];
        dp1[1] = Math.max(nums[0], nums[1]);     
        
        for (int i = 2; i < nums.length - 1; i++) {
            dp1[i] = Math.max(nums[i] + dp1[i - 2], dp1[i - 1]);
        }
        
        int[] dp2 = new int[n - 1];
        dp2[0] = nums[1];
        dp2[1] = Math.max(nums[1], nums[2]);
        
        for (int i = 3, j = 2; i < nums.length; i++, j++) {
            dp2[j] = Math.max(nums[i] + dp2[j - 2], dp2[j - 1]);
        }
        
        //System.out.println(Arrays.toString(dp1));
        //System.out.println(Arrays.toString(dp2));
        
        return Math.max(dp1[n - 2], dp2[n - 2]);
    }
}