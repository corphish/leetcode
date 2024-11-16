// https://leetcode.com/problems/shortest-subarray-with-or-at-least-k-ii
class Solution {
    public int minimumSubarrayLength(int[] nums, int k) {
        int[] bits = new int[32];
        int min = nums.length * 2;
        int l = 0, r = 0;
        int v = -1;

        if (k == 0) {
            return 1;
        }

        while (l <= r) {
            if (v < k) {
                if (r < nums.length) {
                    set(bits, nums[r]);
                    v = valueOf(bits);
                    r += 1;
                } else {
                    break;
                }
            } else {
                min = Math.min(min, r - l);

                if (l < nums.length) {
                    unset(bits, nums[l]);
                    v = valueOf(bits);
                    l += 1;
                }
            }
        }

        return min == nums.length * 2 ? -1 : min;
    }

    int valueOf(int[] bits) {
        int val = 0;
        for (int i = 0; i < 32; i++) {
            val += Math.min(1, bits[i]) * (1 << i);
        }

        return val;
    }

    void set(int[] bits, int x) {
        for (int i = 0; x > 0; x >>= 1, i++) {
            bits[i] += (x & 1);
        }
    }

    void unset(int[] bits, int x) {
        for (int i = 0; x > 0; x >>= 1, i++) {
            bits[i] -= (x & 1);
            bits[i] = Math.max(0, bits[i]);
        }
    }
}