// https://leetcode.com/problems/zero-array-transformation-i
class Solution {
    public boolean isZeroArray(int[] nums, int[][] queries) {
        int[] arr = new int[nums.length + 1];
        for (int[] q: queries) {
            arr[q[0]] += 1;
            arr[q[1] + 1] -= 1;
        }

        for (int i = 1; i < arr.length; i++) {
            arr[i] += arr[i - 1];
            if (nums[i - 1] - arr[i - 1] > 0) {
                return false;
            }
        }

        return true;
    }
}