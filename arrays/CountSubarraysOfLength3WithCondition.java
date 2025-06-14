// https://leetcode.com/problems/count-subarrays-of-length-three-with-a-condition
class Solution {
    public int countSubarrays(int[] nums) {
        int count = 0;
        for (int i = 1; i < nums.length - 1; i++) {
            int sum = (nums[i - 1] + nums[i + 1]);
            if (nums[i] % 2 == 0 && sum * 2 == nums[i]) {
                count += 1;
            }
        }

        return count;
    }
}