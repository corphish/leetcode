class Solution {
    // No. of strings that can be formed starting with:
    // a -> Sum of all strings that can be formed of length n - 1
    // other than a -> Number of strings that can be formed starting with character that comes just before the current character of length n - Number of strings that can be formed starting with character that comes just before the current character of length n - 1
    public int countVowelStrings(int n) {
        int[][] dp = new int[5][n + 1];
        for (int i = 0; i < 5; i++) {
            dp[i][0] = 1;
        }
        
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < 5; j++) {
                if (j == 0) {
                    int sum = 0;
                    for (int k = 0; k < 5; k++) {
                        sum += dp[k][i - 1];
                    }
                    dp[j][i] = sum;
                } else {
                    dp[j][i] =  dp[j - 1][i] - dp[j - 1][i - 1];
                }
            }
            
            //print(dp);
        }
        
        return dp[0][n];
    }
    
    /*void print(int[][] dp) {
        for (int[] d: dp) System.out.println(Arrays.toString(d));
    }*/
}