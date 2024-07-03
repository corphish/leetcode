// https://leetcode.com/problems/minimum-operations-to-make-binary-array-elements-equal-to-one-i
class Solution {
    public int minOperations(int[] nums) {
        return minKBitFlips(nums, 3);
    }

    public int minKBitFlips(int[] nums, int k) {
        int count = 0, soFar = 0;
        int[] flips = new int[nums.length];
        boolean[] wasFlipped = new boolean[nums.length];

        for (int i = 0; i < nums.length; i++) {
            if (i <= nums.length - k) {
                if (i < k) {
                    if (nums[i] == soFar % 2) {
                        soFar += 1;
                        count += 1;
                        wasFlipped[i] = true;
                    }

                    flips[i] = soFar;
                } else {
                    if (wasFlipped[i - k]) {
                        soFar -= 1;
                    }
                    if (nums[i] == soFar % 2) {
                        soFar += 1;
                        count += 1;
                        wasFlipped[i] = true;
                    }
                    flips[i] = soFar;
                }
            } else {
                if (i >= k) {
                    if (wasFlipped[i - k]) {
                        soFar -= 1;
                    }
                    
                    flips[i] = soFar;
                } else {
                   flips[i] = soFar;
                }
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == flips[i] % 2) {
                return -1;
            }
        }

        return count;
    }
}