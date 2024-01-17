// https://leetcode.com/problems/unique-number-of-occurrences
class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        int[][] freq = new int[2][2001];
        for (int x : arr)
            freq[0][1000 + x]++;

        for (int i = 0; i <= 2000; i++) {
            if (freq[0][i] != 0) {
                freq[1][freq[0][i]]++;
                if (freq[1][freq[0][i]] > 1)
                    return false;
            }
        }

        return true;
    }
}