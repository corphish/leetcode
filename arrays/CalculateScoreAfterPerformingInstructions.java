// https://leetcode.com/problems/calculate-score-after-performing-instructions/
class Solution {
    public long calculateScore(String[] instructions, int[] values) {
        long sum = 0;
        int i = 0;
        Set<Integer> done = new HashSet<>();

        while (i >= 0 && i < instructions.length && done.add(i)) {
            String s = instructions[i];

            if ("jump".equals(s)) {
                i += values[i];
            } else {
                sum += values[i];
                i += 1;
            }
        }

        return sum;
    }
}