// https://leetcode.com/problems/subarrays-distinct-element-sum-of-squares-i/
class Solution {
    public int sumCounts(List<Integer> nums) {
        int res = 0;

        for (int i = 0; i < nums.size(); i++) {
            for (int j = i; j < nums.size(); j++) {
                Set<Integer> set = new HashSet<>();
                for (int k = i; k <= j; k++) {
                    set.add(nums.get(k));
                }

                res += set.size() * set.size();
            }
        }

        return res;
    }
}