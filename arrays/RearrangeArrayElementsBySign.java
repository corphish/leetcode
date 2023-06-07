// https://leetcode.com/problems/rearrange-array-elements-by-sign
class Solution {
    public int[] rearrangeArray(int[] nums) {
        int p = -1, n = -1, k = 0, res[] = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0 && p == -1) {
                p = i;
            } else if (nums[i] < 0 && n == -1) {
                n = i;
            }

            if (p >= 0 && n >= 0) break;
        }

        for (; k < nums.length; k += 2) {
            res[k] = nums[p];
            res[k + 1] = nums[n];

            for (int j = p + 1; j < nums.length; j++) {
                if (nums[j] > 0) {
                    p = j;
                    break;
                }
            }

            for (int j = n + 1; j < nums.length; j++) {
                if (nums[j] < 0) {
                    n = j;
                    break;
                }
            }
        }

        return res;
    }
}