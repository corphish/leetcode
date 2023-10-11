// https://leetcode.com/problems/remove-colored-pieces-if-both-neighbors-are-the-same-color/
class Solution {
    public boolean winnerOfGame(String colors) {
        int scoreA = 0, scoreB = 0;
        int lastA = -1, lastB = -1;
        int i = 0;
        char last = '-';

        for (char c: colors.toCharArray()) {
            if (last != c) {
                if (last == 'B') {
                    scoreB += Math.max(0, i - lastB - 2);
                    lastA = i;
                } else if (last == 'A') {
                    scoreA += Math.max(0, i - lastA - 2);
                    lastB = i;
                } else {
                    if (c == 'A') {
                        lastA = i;
                    } else {
                        lastB = i;
                    }
                }
            }

            last = c;
            i += 1;
        }
        
        if (last == 'B') {
            scoreB += Math.max(0, i - lastB - 2);
        } else {
            scoreA += Math.max(0, i - lastA - 2);
        }

        return scoreA > scoreB;
    }
}