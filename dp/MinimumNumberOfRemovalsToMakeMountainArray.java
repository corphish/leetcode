// https://leetcode.com/problems/minimum-number-of-removals-to-make-mountain-array
class Solution {
    public int minimumMountainRemovals(int[] nums) {
        // Trick is to know the max length of susbsequence ending at an index in lis[]
        int[] lis = new int[nums.length + 1];

        // Trick is to know the max length of susbsequence starting from an index in lds[]
        int[] lds = new int[nums.length + 1];

        for (int i = 0; i < nums.length; i++) {
            lis[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    lis[i] = Math.max(lis[i], 1 + lis[j]);
                }
            }
        }

        for (int i = nums.length; i >= 0; i--) {
            lds[i] = 1;
            if (i == nums.length) {
                lds[i] = 0;
            } else {
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[j] < nums[i]) {
                        lds[i] = Math.max(lds[i], 1 + lds[j]);
                    }
                }
            }
        }

        int max = 0;

        for (int i = 0; i < nums.length; i++) {
            if (lis[i] > 1 && lds[i] > 1) {
                max = Math.max(max, lis[i] + lds[i] - 1);
            }
        }

        return nums.length - max;
    }
}