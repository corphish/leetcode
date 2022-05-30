// https://leetcode.com/problems/sum-of-even-numbers-after-queries
class Solution {
    public int[] sumEvenAfterQueries(int[] nums, int[][] queries) {
        int sum = 0, count = 0;
        int[] res = new int[queries.length];
        
        for (int x: nums) {
            if (x % 2 == 0) sum += x;
        }
        
        for (int[] q: queries) {
            if (nums[q[1]] % 2 == 0) {
                sum -= nums[q[1]];
            }
            
            nums[q[1]] += q[0];
            
            if (nums[q[1]] % 2 == 0) {
                sum += nums[q[1]];
            }
            
            res[count++] = sum;
        }
        
        return res;
    }
}