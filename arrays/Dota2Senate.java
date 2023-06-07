// https://leetcode.com/problems/dota2-senate
class Solution {
    public String predictPartyVictory(String s) {
        int n = s.length();
        char[] arr = new char[2 * n];
        int d = -1, r = -1, last = n;

        for (int i = 0; i < n; i++) {
            arr[i] = s.charAt(i);
            if (arr[i] == 'D' && d == -1) {
                d = i;
            }

            if (arr[i] == 'R' && r == -1) {
                r = i;
            }
        }

        for (int i = 0; i < last; i++) {
            if (arr[i] == '-') continue;
            if (arr[i] == 'D') {
                if (r < i) return "Dire";
                // Delete the first R
                arr[r] = '-';
            } else if (arr[i] == 'R') {
                if (d < i) return "Radiant";
                // Delete the first D
                arr[d] = '-';
            }

            arr[last] = arr[i];
            last += 1;

            // Adjust next r and d positions
            for (int j = r + 1; j < last; j++) {
                if (arr[j] == 'R') {
                    r = j;
                    break;
                }
            }

            for (int j = d + 1; j < last; j++) {
                if (arr[j] == 'D') {
                    d = j;
                    break;
                }
            }
        }

        return arr[last - 1] == 'R' ? "Radiant" : "Dire";
    }
}