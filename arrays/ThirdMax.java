// https://leetcode.com/problems/third-maximum-number
class Solution {
    public int thirdMax(int[] nums) {
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);
        
        int a = Integer.MIN_VALUE, b = Integer.MIN_VALUE, c = Integer.MIN_VALUE;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (!set.add(nums[i])) {
                continue;
            }
            
            if (nums[i] > a) {
                c = b;
                b = a;
                a = nums[i];
            } else if (nums[i] > b) {
                c = b;
                b = nums[i];
            } else if (nums[i] > c) {
                c = nums[i];
            }
        }
        
        return set.size() < 3 ? a : c;
    }
}