// https://leetcode.com/problems/find-the-town-judge
class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] trusting = new int[n + 1];
        int[] trusted = new int[n + 1];
        int count = 0;
        
        for (int[] t: trust) {
            trusting[t[0]]++;
            trusted[t[1]]++;
        }
        
        for (int i = 1; i <= n; i++) {
            if (trusted[i] == n - 1 && trusting[i] == 0) {
                return i;
            }
        }
        
        return -1;
    }
}