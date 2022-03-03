// https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;
        Set<Integer> set = new HashSet<>();
        
        for (int i = 1; i <= n; i++) set.add(i);
        for (int x: nums) set.remove(x);
        
        return new ArrayList<>(set);
    }
}