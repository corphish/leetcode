// https://leetcode.com/problems/divide-players-into-teams-of-equal-skill
class Solution {
    public long dividePlayers(int[] skill) {
        long res = 0;
        Arrays.sort(skill);

        int lastSum = -1;
        for (int i = 0, j = skill.length - 1; i <= j; i++, j--) {
            int sum = skill[i] + skill[j];
            if (lastSum == -1) {
                lastSum = sum;
            } else if (lastSum != sum) {
                return -1L;
            }

            res += skill[i] * skill[j];
        }

        return res;
    }
}