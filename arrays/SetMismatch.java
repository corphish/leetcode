// https://leetcode.com/problems/set-mismatch
class Solution {
    public int[] findErrorNums(int[] nums) {
        int n = nums.length, freq[] = new int[n + 1];
        for (int i = 0; i < n; i++) {
            freq[nums[i]]++;
        }
        
        int dup = 0, rem = 0;
        for (int i = 1; i <= n; i++) {
            if (freq[i] == 2) {
                dup = i;
            }
            
            if (freq[i] == 0) {
                rem = i;
            }
        }
        
        return new int[] {dup, rem};
    }
}