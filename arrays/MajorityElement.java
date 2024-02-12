// https://leetcode.com/problems/majority-element
class Solution {
    public int majorityElement(int[] nums) {
        int votes = 0, res = -1;
        for (int i = 0; i < nums.length; i++) {
            if (votes == 0) {
                res = i;
                votes = 1;
            } else if (nums[i] == nums[res]) {
                votes += 1;
            } else {
                votes -= 1;
            }
        }

        return nums[res];
    }
}