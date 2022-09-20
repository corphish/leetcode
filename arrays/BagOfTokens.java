// https://leetcode.com/problems/bag-of-tokens
class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        int score = 0, max = 0;
        
        Arrays.sort(tokens);
        
        if (tokens.length == 0 || tokens[0] > power) {
            return 0;
        }
        
        int i = 0, j = tokens.length - 1;
        
        while (i <= j) {
            if (power < tokens[i]) {
                if (score > 0) {
                    score--;
                    power += tokens[j--];
                } else {
                    break;
                }
            } else {
                score++;
                power -= tokens[i++];
            }
            
            max = Math.max(score, max);
        }
        
        return max;
    }
}