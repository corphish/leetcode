// https://leetcode.com/problems/determine-the-winner-of-a-bowling-game/
class Solution {
    public int isWinner(int[] player1, int[] player2) {
        int sum1 = sum(player1), sum2 = sum(player2);
        return sum1 == sum2 ? 0 : sum1 > sum2 ? 1 : 2;        
    }

    int sum(int[] player) {
        int sum = 0, k = 0;
        for (int x: player) {
            if (k > 0) {
                sum += 2 * x;
            } else {
                sum += x;
            }

            if (x == 10) {
                k = 2;
            } else {
                k--;
            }
        }

        return sum;
    }
}