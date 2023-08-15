// https://leetcode.com/problems/get-equal-substrings-within-budget
class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        int[] cost = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            cost[i] = Math.abs(s.charAt(i) - t.charAt(i));
        }

        int max = 0, start = 0, sum = 0;
        for (int i = 0; i < cost.length; i++) {
            sum += cost[i];
            if (sum > maxCost) {
                sum -= cost[start];
                start += 1;
            }

            max = Math.max(max, i - start + 1);
        }

        return max;
    }
}