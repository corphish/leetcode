// https://leetcode.com/problems/sort-array-by-parity
class Solution {
    public int[] sortArrayByParity(int[] nums) {
        return Arrays.stream(nums)
            .boxed()
            .sorted((a, b) -> (a & 1) - (b & 1))
            .mapToInt(x -> x.intValue())
            .toArray();
    }
}