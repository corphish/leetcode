// https://leetcode.com/problems/minimum-replacements-to-sort-the-array
class Solution {
    public long minimumReplacement(int[] nums) {
        long moves = 0;
        int n = nums.length;

        if (n == 1) {
            return 0;
        }

        int last = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] > last) {
                int[] res = reduce(nums[i], last);
                moves += res[0];
                last = res[1];
            } else {
                last = nums[i];
            }
        }

        return moves;
    }

    // Returns 2 numbers.
    // res[0] = number of moves to reduce
    // res[1] = min number after reduction
    int[] reduce(int n, int l) {
        return new int[] {
            n % l == 0 ? n/l - 1 : n/l,
            n % l == 0 ? l : n/(n/l + 1),
        };
    }
}