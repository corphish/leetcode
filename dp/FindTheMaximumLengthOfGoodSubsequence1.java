// https://leetcode.com/problems/find-the-maximum-length-of-a-good-subsequence-i/
class Solution {
    public int maximumLength(int[] nums, int k) {
        remap(nums);
        int[][] dp = new int[nums.length + 1][k + 1];

        for (int i = nums.length; i >= 0; i--) {
            for (int x = 0; x <= k; x++) {
                if (i == nums.length) {
                    dp[i][x] = 0;
                    continue;
                }

                int max = 1;
                int count = 1;

                // Attempt to make pairs
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[i] == nums[j]) {
                        count += 1;
                    } else {
                        if (x > 0) {
                            max = Math.max(max, count + dp[j][x - 1]);
                        }
                    }
                }

                max = Math.max(max, count);

                // Skip
                max = Math.max(max, dp[i + 1][x]);
                dp[i][x] = max;
            }
        }

        return dp[0][k];
    }

    int max(int[] nums, int i, int k) {
        if (i == nums.length) {
            return 0;
        }

        int max = 1;
        int count = 1;

        // Attempt to make pairs
        for (int j = i + 1; j < nums.length; j++) {
            if (nums[i] == nums[j]) {
                count += 1;
            } else {
                if (k > 0) {
                    max = Math.max(max, count + max(nums, j, k - 1));
                }
            }
        }

        // Skip
        max = Math.max(max, count);
        max = Math.max(max, max(nums, i + 1, k));
        return max;
    }

    void remap(int[] nums) {
        int x = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                nums[i] = map.get(nums[i]);
            } else {
                map.put(nums[i], x);
                nums[i] = x;
                x += 1;
            }
        } 
    }
}