// https://leetcode.com/problems/number-of-subsequences-that-satisfy-the-given-sum-condition
// Number of subsequences possible of an array of length is 2^(length - 1)
class Solution {
    public int numSubseq(int[] nums, int target) {
        long count = 0;

        Arrays.sort(nums);

        int[] map = new int[nums[nums.length - 1] + 1];
        Arrays.fill(map, -1);
        for (int i = 0; i < nums.length; i++) {
            map[nums[i]] = i;
        }

        int last = -1;
        for (int i = 0; i < map.length; i++) {
            if (map[i] == -1) {
                map[i] = last;
            } else {
                last = -i;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            int upper = target - nums[i];
            if (upper < nums[i]) continue;

            int ix = upper >= map.length ? map[map.length - 1] : map[upper];
            if (ix < 0) {
                int lastAvailable = -ix;
                ix = map[lastAvailable];
            }

            count += modPow(2, ix - i);
            count %= 1000000007;
        }

        return (int) count;
    }

    long modPow(long base, int exp) {
        long res = 1;
        long mod = 1000000007;
        base %= mod;

        while (exp > 0) {
            if (exp % 2 == 1) {
                res = (res * base) % mod;
            }

            exp >>= 1;
            base = (base * base) % mod;
        }

        return res;
    }
}