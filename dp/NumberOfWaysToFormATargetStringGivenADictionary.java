// https://leetcode.com/problems/number-of-ways-to-form-a-target-string-given-a-dictionary
class Solution {
    public int numWays(String[] words, String target) {
        int[][] freq = new int[26][words[0].length()];

        for (String word: words) {
            for (int i = 0; i < word.length(); i++) {
                freq[word.charAt(i) - 'a'][i]++;
            }
        }

        long[][] dp = new long[target.length()][words[0].length()];
        long[][] prefix = new long[target.length()][words[0].length()];
        long res = 0;
        for (int i = dp.length - 1, b = 0; i >= 0; i--, b++) {
            if (i == dp.length - 1) {
                // Copy the last row of the last letter of freq
                for (int j = 0; j < words[0].length(); j++) {
                    dp[i][j] = freq[target.charAt(i) - 'a'][j];
                }
            } else {
                for (int j = words[0].length() - b; j >= 0; j--) {
                    long cnt = freq[target.charAt(i) - 'a'][j] * prefix[i + 1][words[0].length() - 1] - 
                                freq[target.charAt(i) - 'a'][j] * prefix[i + 1][j];
                    dp[i][j] = cnt % 1000000007;

                    // Result will be sum of all the possibilities when i = 0, because we can
                    // choose to start from any index given that it is less than words[0].length - target.length.
                    if (i == 0) res += cnt;
                }
            }

            /**
             * Maintain a prefix sum array for the newly calculated dp row.
             * This will help to efficiently calculate product of dp[i+1][j..end]
             */
            for (int j = 0; j < words[0].length(); j++) {
                if (j == 0)
                    prefix[i][j] = dp[i][j];
                else {
                    prefix[i][j] = prefix[i][j - 1] + dp[i][j];
                }
            }
        }

        return (int) (res % 1000000007);
    }
}