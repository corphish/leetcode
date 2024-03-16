// https://leetcode.com/problems/contiguous-array/
class Solution {
    // [1 0 0 1 1 1 0]
    // [1 0 -1 0 1 2 1]
    // [0 1 0]
    // [-1 0 -1]
    public int findMaxLength(int[] nums) {
        Map<Integer, Integer> index = new HashMap<>();
        int max = 0;

        for (int i = 0; i < nums.length; i++) {
            int k = nums[i] == 0 ? -1 : 1;
            if (i == 0) {
                nums[i] = k;
            } else {
                nums[i] = nums[i - 1] + k;
            }

            if (!index.containsKey(nums[i])) {
                index.put(nums[i], i);
            }

            if (nums[i] == 0) {
                max = Math.max(max, i + 1);
            } else {
                max = Math.max(max, i - index.getOrDefault(nums[i], i));
            }
        }

        return max;
    }
}