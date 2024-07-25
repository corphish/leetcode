// https://leetcode.com/problems/find-the-winner-of-the-circular-game
class Solution {
    public int findTheWinner(int n, int k) {
        return g(n, k) + 1;
    }

    int g(int n, int k) {
        if (n == 1) {
            return 0;
        }

        return ((g(n - 1, k) + k) % n);
    }
}