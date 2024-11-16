// https://leetcode.com/problems/find-the-longest-substring-containing-vowels-in-even-counts
class Solution {
    public int findTheLongestSubstring(String s) {
        int last = (1 << 5) - 1;
        int max = 0;
        int[] pfx = new int[s.length()];

        int[] first = new int[1 << 5];
        Arrays.fill(first, -1);

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int mask = 1 << (c == 'a' ? 0 : c == 'e' ? 1 : c == 'i' ? 2 : c == 'o' ? 3 : c == 'u' ? 4 : 6);
            if (mask <= (1 << 4)) {
                pfx[i] = last ^ mask;
                last = pfx[i];
            } else {
                pfx[i] = last;
            }

            if (pfx[i] == 31) {
                max = i + 1;
            }
            
            if (first[pfx[i]] == -1) {
                first[pfx[i]] = i;
            }

            max = Math.max(max,  i - first[pfx[i]]);
        }

        return max;
    }
}