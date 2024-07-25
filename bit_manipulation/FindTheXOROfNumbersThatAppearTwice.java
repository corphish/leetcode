// https://leetcode.com/problems/find-the-xor-of-numbers-which-appear-twice/
class Solution {
    public int duplicateNumbersXOR(int[] nums) {
        int res = 0;
        int[] freq = new int[51];

        for (int x: nums) {
            freq[x] += 1;
            if (freq[x] == 2) {
                res = res ^ x;
            }
        }

        return res;
    }
}