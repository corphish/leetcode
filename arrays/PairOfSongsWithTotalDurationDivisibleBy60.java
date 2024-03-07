// https://leetcode.com/problems/pairs-of-songs-with-total-durations-divisible-by-60/
class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        int[] freq = new int[60];
        for (int x: time) {
            freq[x % 60] += 1;
        }

        int count = 0;

        for (int i = 0; i <= 30; i++) {
            if (freq[i] == 0) continue;
            if (i == 0 || i == 30) {
                count += freq[i] % 2 == 0 ? (freq[i]/2 * (freq[i] - 1)) : (freq[i] * (freq[i] - 1)/2);
            } else {
                count += freq[i] * freq[60 - i];
            }
        }

        return count;
    }
}