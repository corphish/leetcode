// https://leetcode.com/problems/rabbits-in-forest
class Solution {
    public int numRabbits(int[] answers) {
        int[] freq = new int[1001];
        int res = 0;

        for (int x: answers) {
            if (x == 0) {
                res += 1;
            } else {
                if (freq[x] == 0) {
                    res += x + 1;
                    freq[x] = x;
                } else {
                    freq[x] -= 1;
                }
            }
        }

        return res;
    }
}