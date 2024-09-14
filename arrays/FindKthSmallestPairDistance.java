// https://leetcode.com/problems/find-k-th-smallest-pair-distance
class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int[] freq = new int[nums[nums.length - 1] + 1];

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                freq[nums[j] - nums[i]] += 1;
            }
        }

        for (int i = 0; i < freq.length; i++) {
            int x = freq[i];
            if (k <= x) return i;
            k -= x;
        }

        return 0;
    }
}