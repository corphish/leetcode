// https://leetcode.com/problems/longest-subsequence-with-limited-sum/
class Solution {
    public int[] answerQueries(int[] nums, int[] queries) {
        int[] res = new int[queries.length];
        Arrays.sort(nums);
        int k = 0;
        for (int q: queries) {
            int sum = 0;
            for (int i = 0; i < nums.length; i++) {
                sum += nums[i];
                if (i == nums.length - 1 && sum <= q) {
                    res[k++] = nums.length;
                    break;
                }

                if (sum > q) {
                    res[k++] = i;
                    break;
                }
            }
        }

        return res;
    }
}