// https://leetcode.com/problems/divide-array-into-arrays-with-max-difference/
class Solution {
    public int[][] divideArray(int[] nums, int k) {
        Arrays.sort(nums);
        int[][] res = new int[nums.length/3][3];

        for (int i = 0, x = 0; i < nums.length; i += 3, x += 1) {
            if (nums[i + 2] - nums[i] <= k) {
                res[x][0] = nums[i];
                res[x][1] = nums[i + 1];
                res[x][2] = nums[i + 2];
            } else {
                return new int[][] {};
            }
        }

        return res;
    }
}