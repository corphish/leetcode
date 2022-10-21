// https://leetcode.com/problems/find-all-duplicates-in-an-array
// True O(n) solution with constant space
// Idea is to use the input array as hashtable
// We can make index value negative when we encounter a value for the first time
// And then we can check the index value, if it is already negative means it is duplicate.
class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();
        
        for (int i = 0; i < nums.length; i++) {
            int val = Math.abs(nums[i]);
            if (nums[val - 1] < 0) {
                res.add(val);
            } else {
                nums[val - 1] *= -1;
            }
        }
        
        return res;
    }
}