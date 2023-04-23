// https://leetcode.com/problems/replace-elements-in-an-array
class Solution {
    public int[] arrayChange(int[] nums, int[][] operations) {
        Map<Integer, Integer> ixMap = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            ixMap.put(nums[i], i);
        }
        
        for (int[] op: operations) {
            int old = op[0];
            int newNum = op[1];
            
            int ix = ixMap.get(old);
            nums[ix] = newNum;
            
            ixMap.remove(old);
            ixMap.put(newNum, ix);
        }
        
        return nums;
    }
}