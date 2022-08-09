// Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.
class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> s = new HashSet<>();
        for (int x: nums) s.add(x);
        
        return nums.length != s.size();
    }
}