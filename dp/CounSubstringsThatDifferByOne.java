// https://leetcode.com/problems/count-substrings-that-differ-by-one-character
class Solution {
    // Check https://leetcode.com/problems/count-substrings-that-differ-by-one-character/discuss/1976573/Java-or-DP-explained
    // for explanation.
    public int countSubstrings(String s, String t) {
        int lenS = s.length(), lenT = t.length();
        int count = 0;
        
        // DP1 - Number of substring of s ending at i is equal to substring of t ending at j
        int[][] dp1 = new int[lenS][lenT];
        
        // DP2 - Number of substring of s ending at i that differ by one char from substring of t ending at j
        int[][] dp2 = new int[lenS][lenT];
        
        for (int i = 0; i < lenS; i++) {
            for (int j = 0; j < lenT; j++) {
                boolean match = s.charAt(i) == t.charAt(j);
                
                if (i == 0 || j == 0) {
                    if (match) {
                        dp1[i][j] = 1;
                        dp2[i][j] = 0;
                    } else {
                        dp1[i][j] = 0;
                        dp2[i][j] = 1;
                    }
                } else {
                    if (match) {
                        dp1[i][j] = dp1[i - 1][j - 1] + 1;
                        dp2[i][j] = dp2[i - 1][j - 1];
                    } else {
                        dp1[i][j] = 0;
                        dp2[i][j] = dp1[i - 1][j - 1] + 1;
                    }
                }
                
                count += dp2[i][j];
                //print(dp1, "DP1 (" + i + ", " + j + ")");
                //print(dp2, "DP2 (" + i + ", " + j + ")");
            }
        }
        
        return count;
    }
    
    void print(int[][] arr, String tag) {
        System.out.println(tag);
        for (int[] a: arr) {
            System.out.println(Arrays.toString(a));
        }
    }
}