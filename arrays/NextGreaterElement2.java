// https://leetcode.com/problems/next-greater-element-ii
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int[] res = new int[nums.length];
        Arrays.fill(res, -1);
        for (int i = 0; i < nums.length; i++) {
            for (int j = i == nums.length - 1 ? 0 : i + 1; j != i; j = j == nums.length - 1 ? 0 : j + 1) {
                if (nums[j] > nums[i]) {
                    res[i] = nums[j];
                    break;
                }
            }
        }
        
        return res;
    }
}