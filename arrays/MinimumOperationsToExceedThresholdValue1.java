// https://leetcode.com/problems/minimum-operations-to-exceed-threshold-value-i/
class Solution {
    public int minOperations(int[] nums, int k) {
        Arrays.sort(nums);
        int ix = Arrays.binarySearch(nums, k);

        int count = 0;
        while (nums[count] < k) {
            count++;
        }

        return count;
    }
}