// https://leetcode.com/problems/crawler-log-folder/
class Solution {
    public int minOperations(String[] logs) {
        int count = 0;
        for (String log: logs) {
            if ("../".equals(log)) {
                count -= 1;
            } else if ("./".equals(log)) {
                count += 0;
            } else {
                count += 1;
            }

            count = Math.max(0, count);
        }

        return count;
    }
}