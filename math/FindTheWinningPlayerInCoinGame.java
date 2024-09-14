// https://leetcode.com/problems/find-the-winning-player-in-coin-game
class Solution {
    public String losingPlayer(int x, int y) {
        int k = 0;
        while (true) {
            if (x < 1 || y < 4) {
                break;
            }
            
            x -= 1;
            y -= 4;
            k += 1;
        }

        return k % 2 == 0 ? "Bob" : "Alice";
    }
}