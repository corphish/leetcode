class Solution {
    // Logic: Start from the end to build the dp
    // If it is possible to jump to end from ith position: dp[i] = 1
    // If it is not possible: Jump to next one in range with minimum dp value
    // Return dp[0]
    public int jump(int[] nums) {
        if (nums.length == 1) return 0;
        int[] stepsToEnd = new int[nums.length];
        
        // We disregard the nums[i] whose value is 0
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] == 0) {
                stepsToEnd[i] = Integer.MAX_VALUE;
            } else {
                if (i + nums[i] >= nums.length - 1) {
                    stepsToEnd[i] = 1;
                } else {
                    int min = Integer.MAX_VALUE;
                    for (int j = i; j <= i + nums[i]; j++) {
                        if (stepsToEnd[j] != 0)
                            min = Math.min(min, stepsToEnd[j]);
                    }
                    
                    if (min != Integer.MAX_VALUE)
                        stepsToEnd[i] = min + 1;
                    else
                        stepsToEnd[i] = Integer.MAX_VALUE;
                }
            }
        }
        
        //System.out.println(Arrays.toString(stepsToEnd));
        return stepsToEnd[0] == Integer.MAX_VALUE ? 0 : stepsToEnd[0];
    }
}