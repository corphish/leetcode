// https://leetcode.com/problems/stone-game-vi
class Solution {
    public int stoneGameVI(int[] aliceValues, int[] bobValues) {
        int alice = 0, bob = 0, n = aliceValues.length;
        Stone[] stones = new Stone[n];
        for (int i = 0; i < n; i++) {
            stones[i] = new Stone(aliceValues[i], bobValues[i]);
        }

        Arrays.sort(stones);
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                alice += stones[i].alice;
            } else {
                bob += stones[i].bob;
            }
        }

        return alice == bob ? 0 : alice > bob ? 1 : -1;
    }

    class Stone implements Comparable<Stone> {
        int alice, bob, total;

        Stone(int alice, int bob) {
            this.alice = alice;
            this.bob = bob;
            this.total = alice + bob;
        }

        public int compareTo(Stone other) {
            return other.total - this.total;
        }
    }
}