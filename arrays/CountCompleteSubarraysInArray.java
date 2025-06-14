// https://leetcode.com/problems/count-complete-subarrays-in-an-array
class Solution {
    public int countCompleteSubarrays(int[] nums) {
        int[] freq = new int[2001];

        for (int x: nums) {
            freq[x] += 1;
        }

        int dist = 0, count = 0;
        for (int x: freq) {
            if (x > 0) dist += 1;
        }

        for (int i = dist; i <= nums.length; i++) {
            Arrays.fill(freq, 0);
            int k = 0;

            int l = 0, r = 0;
            for (; r < i; r++) {
                freq[nums[r]] += 1;
                if (freq[nums[r]] == 1) {
                    k += 1;
                }
            }

            if (k == dist) {
                count += 1;
            }

            for (; r < nums.length; r++, l++) {
                freq[nums[r]] += 1;

                if (freq[nums[r]] == 1) {
                    k += 1;
                }

                freq[nums[l]] -= 1;

                if (freq[nums[l]] == 0) {
                    k -= 1;
                }

                if (k == dist) {
                    count += 1;
                }
            }
        }

        return count;
    }
}