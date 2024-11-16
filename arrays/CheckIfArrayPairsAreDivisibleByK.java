// https://leetcode.com/problems/check-if-array-pairs-are-divisible-by-k
class Solution {
    public boolean canArrange(int[] arr, int k) {
        int[] freq = new int[k];
        for (int x: arr) freq[((x % k) + k) % k] += 1;
        
        for (int i = 0; i < k; i++) {
            if (i == 0 && freq[i] % 2 == 1) {
                return false;
            }

            if (i > 0 && freq[i] != freq[k - i]) {
                return false;
            }
        }

        return true;
    }
}