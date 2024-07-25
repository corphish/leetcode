// https://leetcode.com/problems/number-of-rectangles-that-can-form-the-largest-square/
class Solution {
    public int countGoodRectangles(int[][] rectangles) {
        TreeMap<Integer, Integer> freq = new TreeMap<>();
        int max = 0;
        for (int[] r : rectangles) {
            int len = Math.min(r[0], r[1]);
            freq.put(len, freq.getOrDefault(len, 0) + 1);
        }

        return freq.lastEntry().getValue();
    }
}