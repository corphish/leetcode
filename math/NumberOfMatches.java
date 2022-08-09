// https://leetcode.com/problems/count-of-matches-in-tournament/
class Solution {
    public int numberOfMatches(int n) {
        int matches = 0;
        while (n > 0) {
            matches += n/2;
            n = n % 2 == 0 ? n/2 : n/2 + 1;
            if (n == 1) break;
        }
        
        return matches;
    }
}