class Solution {
    // Generate the triplets as per triangle spec
    public int triangleNumber(int[] nums) {
        if (nums.length < 3) return 0;
        Arrays.sort(nums);
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length && nums[i] + nums[j] > nums[k]; k++, count++);
            }
        }
        
        return Math.max(0, count);
    }
}