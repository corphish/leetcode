// https://leetcode.com/problems/number-of-students-doing-homework-at-a-given-time/
class Solution {
    public int busyStudent(int[] start, int[] end, int queryTime) {
        int[] q = new int[1002];

        for (int i = 0; i < start.length; i++) {
            q[start[i]] += 1;
            q[end[i] + 1] -= 1;
        }

        for (int i = 1; i < q.length; i++) {
            q[i] += q[i - 1];
        }

        return q[queryTime];
    }
}