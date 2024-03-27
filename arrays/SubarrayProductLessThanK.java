// https://leetcode.com/problems/subarray-product-less-than-k/
class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int count = 0;
        int p = 1;
        int l = 0, r = 0;

        while (r < nums.length) {
            p *= nums[r];
            r += 1;

            while (p >= k && l < r) {
                p /= nums[l];
                l += 1;
            }

            if (p < k)
                count += (r - l);
        }

        return count;
    }
}