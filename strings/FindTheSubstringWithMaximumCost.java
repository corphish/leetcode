// https://leetcode.com/problems/find-the-substring-with-maximum-cost
class Solution {
    public int maximumCostSubstring(String s, String chars, int[] vals) {
        int[] cost = new int[26];
        for (int i = 0; i < chars.length(); i++) {
            cost[chars.charAt(i) - 'a'] = vals[i] == 0 ? Integer.MIN_VALUE : vals[i];
        }

        int[] arr = new int[s.length()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = cost[s.charAt(i) - 'a'];
            if (arr[i] == 0) {
                arr[i] = s.charAt(i) - 96;
            } else if (arr[i] == Integer.MIN_VALUE) {
                arr[i] = 0;
            }
        }

        return maxSubArraySum(arr);
    }

    int maxSubArraySum(int a[]) {
        int size = a.length;
        int max_so_far = 0, max_ending_here
                                            = 0;
 
        for (int i = 0; i < size; i++) {
            max_ending_here = max_ending_here + a[i];
            if (max_so_far < max_ending_here)
                max_so_far = max_ending_here;
            if (max_ending_here < 0)
                max_ending_here = 0;
        }
        return max_so_far;
    }
}