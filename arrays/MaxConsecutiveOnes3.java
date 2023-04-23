// https://leetcode.com/problems/max-consecutive-ones-iii
class Solution {
    public int longestOnes(int[] nums, int k) {
        int l = 0, r = 0, count = 0;

        // If k is 0, return max consecutive ones
        int res = 0;
        int max = res;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                max = Math.max(max, res);
                res = 0;
            } else {
                res += 1;
            }
        }

        max = Math.max(max, res);

        // Initially extend r until we encounter k zeroes
        for (; count <= k && r < nums.length; r++) {
            if (nums[r] == 0) {
                count++;
            }
        }

        // From this point, l and r are inclusive
        // If count > k, we keep on extending l
        // l == r, we extend r and check nums[r]
        for (r -= 2, count--; l < nums.length;) {
            if (count <= k)
                max = Math.max(max, r - l + 1);
            if (l == r) {
                if (r < nums.length - 1) {
                    r += 1;
                    if (nums[r] == 0) {
                        count++;
                    }
                } else {
                    break;
                }
            }

            if (count > k) {
                if (nums[l] == 0) {
                    count--;
                }
                l += 1;
            } else {
                if (r != nums.length - 1) {
                    r += 1;
                    if (nums[r] == 0) {
                        count++;
                    }
                } else {
                    l += 1;
                }
            }
        }
        
        return max;
    }
}