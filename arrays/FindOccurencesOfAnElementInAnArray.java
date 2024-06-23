// https://leetcode.com/problems/find-occurrences-of-an-element-in-an-array/
class Solution {
    public int[] occurrencesOfElement(int[] nums, int[] queries, int x) {
        int[] pos = new int[nums.length + 1];
        Arrays.fill(pos, -1);
        int k = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == x) {
                pos[++k] = i;
            }
        }

        int[] res = new int[queries.length];
        int i = 0;
        for (int q: queries) {
            if (q > nums.length) {
                res[i++] = -1;
            } else {
                res[i++] = pos[q];
            }
        }

        return res;
    }
}