// https://leetcode.com/problems/assign-cookies
class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int ptr = g.length - 1;
        int count = 0;

        if (s.length == 0) {
            return 0;
        }

        for (; ptr >= 0; ptr--) {
            if (s[s.length - 1] >= g[ptr]) {
                break;
            }
        }

        for (int i = s.length - 1; i >= 0; i--) {
            if (s[i] >= g[ptr]) {
                ptr -= 1;
                count += 1;
            } else {
                int k = ptr;
                for (; k >= 0 && s[i] < g[k]; k--);
                if (k < 0) {
                    continue;
                } else {
                    count += 1;
                    ptr = k - 1;
                }
            }

            if (ptr < 0) {
                break;
            }
        }

        return count;
    }
}