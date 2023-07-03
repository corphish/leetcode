// (a[i] - a[0]) + (a[i] - a[1]) + .. (a[i] - a[i - 1]) + (a[i + 1] - a[i]) + (a[i + 2] - a[i]) + .. + a([n - 1] - a[i])
// (i*a[i] - sum of a[0]..a[i - 1]) + (sum of a[i + 1]..a[n - 1] + (n - i + 1)*a[i])
// https://leetcode.com/problems/sum-of-absolute-differences-in-a-sorted-array/
class Solution {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int n = nums.length;
        int[] prefix = nums.clone();
        int[] res = new int[n];

        for (int i = 1; i < n; i++) {
            prefix[i] += prefix[i - 1];
        }

        for (int i = 0; i < n; i++) {
            res[i] = (i * nums[i]) - (i == 0 ? 0 : prefix[i - 1]) + ((prefix[n - 1] - prefix[i]) - (n - i - 1) * nums[i]); 
        }

        return res;
    }
}