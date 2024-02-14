// https://leetcode.com/problems/count-elements-with-maximum-frequency/
class Solution {
    public int maxFrequencyElements(int[] nums) {
        int[] freq = new int[101];
        for (int x : nums) {
            freq[x] += 1;
        }

        int max = 0, sum = 0;
        for (int x : freq) {
            if (x > max) {
                sum = x;
                max = x;
            } else if (x == max) {
                sum += x;
            }
        }

        return sum;
    }
}