// https://leetcode.com/problems/maximum-compatibility-score-sum
class Solution {
    int max = 0;
    public int maxCompatibilitySum(int[][] students, int[][] mentors) {
        boolean[] v1 = new boolean[students.length];
        boolean[] v2 = new boolean[mentors.length];

        int[][] scoreMap = new int[students.length][mentors.length];
        for (int i = 0; i < students.length; i++) {
            for (int j = 0; j < mentors.length; j++) {
                int s = 0;
                for (int k = 0; k < students[i].length; k++) {
                    if (students[i][k] == mentors[j][k]) {
                        s += 1;
                    }
                }

                scoreMap[i][j] = s;
            }
        }

        det(students, mentors, v1, v2, scoreMap, 0, 0);
        return max;
    }

    void det(
        int[][] students, 
        int[][] mentors,
        boolean[] v1,
        boolean[] v2,
        int[][] scoreMap,
        int student,
        int score
    ) {
        if (student >= students.length) {
            max = Math.max(max, score);
            return;
        }

        if (v1[student]) {
            return;
        }

        v1[student] = true;

        for (int j = 0; j < mentors.length; j++) {
            if (!v2[j]) {
                v2[j] = true;
                det(students, mentors, v1, v2, scoreMap, student + 1, score + scoreMap[student][j]);
                v2[j] = false;
            }
        }

        v1[student] = false;
    }
}