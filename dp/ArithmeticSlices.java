// https://leetcode.com/problems/arithmetic-slices/
class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int[] dp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (i < 2) {
                dp[i] = 0;
            } else {
                if (nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2]) {
                    int count = 1;
                    for (int j = i - 1; j >= 2; j--) {
                        if (nums[j] - nums[j - 1] == nums[j - 1] - nums[j - 2]) {
                            count += 1;
                        } else {
                            break;
                        }
                    }

                    dp[i] = count + dp[i - 1];
                } else {
                    dp[i] = dp[i - 1];
                }
            }
        }

        return dp[nums.length - 1];
    }

    int count(int[] nums, int i) {
        if (i < 2) {
            return 0;
        }

        if (nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2]) {
            int count = 1;
            for (int j = i - 1; j >= 2; j--) {
                if (nums[j] - nums[j - 1] == nums[j - 1] - nums[j - 2]) {
                    count += 1;
                } else {
                    break;
                }
            }

            return count + count(nums, i - 1);
        } else {
            return count(nums, i - 1);
        }
    }

    // Old but faster
    public int numberOfArithmeticSlicesOld(int[] nums) {
        // If length less than 3, there cannot be any slices.
        if (nums.length < 3)
            return 0;

        // dp array, with 0, 1 value being 0
        int[] dp = new int[nums.length];
        dp[0] = 0;
        dp[1] = 0;

        // Rolling diff
        int diff = 0, i = 0, roll = 0;

        // Find the first i, where nums[i], nums[i + 1] and nums[i + 2] is a slice.
        for (; i < nums.length - 2; i++) {
            if (nums[i + 2] - nums[i + 1] == nums[i + 1] - nums[i]) {
                diff = nums[i + 2] - nums[i + 1];
                dp[i + 2] = 1;
                roll = 1;
                break;
            }
        }

        for (i = i + 1; i < nums.length - 2; i++) {
            if (nums[i + 2] - nums[i + 1] == diff) {
                dp[i + 2] = dp[i + 1] + (++roll);
            } else {
                dp[i + 2] = dp[i + 1];
                roll = 0;
                diff = nums[i + 2] - nums[i + 1];
            }
        }

        // System.out.println(Arrays.toString(dp));

        return dp[nums.length - 1];
    }
}