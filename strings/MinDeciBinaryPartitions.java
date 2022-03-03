// https://leetcode.com/problems/partitioning-into-minimum-number-of-deci-binary-numbers
class Solution {
    public int minPartitions(String n) {
        int max = 0;
        for (int c: n.getBytes()) {
            max = Math.max(c, max);
        }
        
        return max - 48;
    }
}