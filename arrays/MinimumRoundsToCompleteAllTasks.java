// https://leetcode.com/problems/minimum-rounds-to-complete-all-tasks/
class Solution {
    public int minimumRounds(int[] tasks) {
        Map<Integer, Integer> freq = new HashMap<>();
        int rounds = 0;

        for (int task: tasks) {
            freq.put(task, freq.getOrDefault(task, 0) + 1);
        }

        for (var e: freq.values()) {
            if (e < 2) {
                return -1;
            }

            rounds += e % 3 == 0 ? e/3 : e/3 + 1;
        }

        return rounds;
    }
}