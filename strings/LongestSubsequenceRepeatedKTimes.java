// https://leetcode.com/problems/longest-subsequence-repeated-k-times
class Solution {
    String max;
    boolean res;

    public String longestSubsequenceRepeatedK(String s, int k) {
        max = "";
        res = false;
        int[] freq = new int[26];
        char[] arr = s.toCharArray();

        for (char c: arr) {
            freq[c - 'a']++;
        }

        int[][] map = computeMap(arr);
        char[] build = new char[s.length()/k];

        for (int i = s.length()/k; i >= 1; i--) {
            formAndCheck(arr, map, k, freq, build, 0, i);
            if (res) {
                break;
            }
        }

        return max;
    }

    void formAndCheck(
        char[] s,
        int[][] map,
        int k,
        int[] freq,
        char[] build,
        int ix,
        int len
    ) {
        if (ix == len) {
            int r = count(s, map, build, len, k);
            if (r == k) {
                max = new String(build, 0, len);
                res = true;
            }

            return;
        }

        if (res) {
            return;
        }

        for (int i = 25; i >= 0; i--) {
            if (freq[i] >= k) {
                build[ix] = (char) (i + 'a');
                freq[i] -= 1;
                formAndCheck(s, map, k, freq, build, ix + 1, len);
                freq[i] += 1;
                if (res) {
                    return;
                }
            }
        }
    }

    int count(char[] s, int[][] map, char[] sub, int len, int k) {
        int count = 0, last = -1, ptr = 0;
        while (count < k) {
            if (last == -1) {
                int i = 0;
                for (char c: s) {
                    if (c == sub[ptr]) {
                        last = i;
                        break;
                    }

                    i++;
                }
            } else {
                last = map[last][sub[ptr] - 'a'];
            }

            if (last == -1) {
                break;
            }

            ptr += 1;

            if (ptr >= len) {
                count += 1;
                ptr = 0;
            }
        }

        return count;
    }

    int[][] computeMap(char[] arr) {
        int[][] res = new int[arr.length][26];
        for (int[] x: res) {
            Arrays.fill(x, -1);
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (res[i][arr[j] - 'a'] == -1)
                    res[i][arr[j] - 'a'] = j;
            }
        }

        return res;
    }
}