// https://leetcode.com/problems/maximum-length-of-pair-chain/
class Solution {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (a, b) -> a[1] - b[1]);
        int[] last = null;
        int len = 0;

        for (int[] pair: pairs) {
            if (last == null || last[1] < pair[0]) {
                last = pair;
                len += 1;
            }
        }

        return len;
    }
}