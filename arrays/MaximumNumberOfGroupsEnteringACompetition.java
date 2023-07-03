// https://leetcode.com/problems/maximum-number-of-groups-entering-a-competition
class Solution {
    public int maximumGroups(int[] grades) {
        Arrays.sort(grades);
        int count = 0, groupSum = 0, groupCount = 0, lastSum = 0, lastCount = 0;
        int tSize = 1;
        for (int i = 0; i < grades.length; ) {
            groupSum = 0;
            groupCount = 0;
            for (int j = 0; j < tSize; j++) {
                if (i + j >= grades.length) break;
                groupSum += grades[i + j];
                groupCount += 1;
            }

            if (i + tSize < grades.length) {
                i += tSize;
                tSize += 1;
                count += 1;
                lastSum = groupSum;
                lastCount = groupCount;
            } else {
                if (groupSum > lastSum && groupCount > lastCount) {
                    count += 1;
                }

                break;
            }

        }

        return count;
    }
}