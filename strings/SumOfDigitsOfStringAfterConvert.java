// https://leetcode.com/problems/sum-of-digits-of-string-after-convert
class Solution {
    public int getLucky(String s, int k) {
        int sum = 0;
        for (int c: s.getBytes()) {
            sum += (c - 96) % 10 + ((c - 96)/10) % 10;
        }

        while (k > 1) {
            int t = 0;
            while (sum > 0) {
                t += sum % 10;
                sum /= 10;
            }
            sum = t;
            k -= 1;
            if (sum < 10) break;
        }

        return sum;
    }
}