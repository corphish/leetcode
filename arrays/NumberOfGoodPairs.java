// https://leetcode.com/problems/number-of-good-pairs
class Solution {
    public int numIdenticalPairs(int[] nums) {
        int[] freq = new int[101];
        int count = 0;
        for (int x: nums) freq[x]++;
        
        for (int x: freq) {
            count += x * (x - 1)/2;
        }
        
        return count;
    }
}