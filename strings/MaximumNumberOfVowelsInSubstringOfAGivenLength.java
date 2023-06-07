// https://leetcode.com/problems/maximum-number-of-vowels-in-a-substring-of-given-length
class Solution {
    public int maxVowels(String s, int k) {
        int max = 0;
        int l = 0, r = 0, count = 0;
        char[] arr = s.toCharArray();

        for (char c: arr) {
            if (isVowel(c)) {
                count += 1;
            }

            if (r >= k) {
                if (isVowel(arr[l++])) {
                    count -= 1;
                }
            }

            r += 1;

            max = Math.max(max, count);
        }

        return max;
    }

    boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}