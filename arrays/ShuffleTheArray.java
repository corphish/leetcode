// https://leetcode.com/problems/shuffle-the-array
class Solution {
    public int[] shuffle(int[] nums, int n) {
        int[] res = new int[2 * n];
        
        for (int i = 0, j = 0; i < 2 * n; i += 2, j++) {
            res[i] = nums[j];
        }
        
        for (int i = 1, j = n; i < 2 * n; i += 2, j++) {
            res[i] = nums[j];
        }
        
        return res;
    }
}