// https://leetcode.com/problems/minimum-window-substring
class Solution {
    public String minWindow(String s, String t) {
        short[] f1 = new short[64];
        short[] f2 = new short[64];

        if (t.length() > s.length()) {
            return "";
        }

        for (char c: t.toCharArray()) {
            f1[c - 'A'] += 1;
        }

        int l = 0, r = 0; // substring from [l, r)
        int resL = 0, resR = Integer.MAX_VALUE;

        for (;;) {
            if (r >= s.length()) {
                if (l == r) {
                    break;
                }

                if (isValid(f1, f2)) {
                    if (r - l < resR - resL) {
                        resL = l;
                        resR = r;
                    }
                }

                char delete = s.charAt(l++);
                f2[delete -'A'] -= 1;

                if (isValid(f1, f2)) {
                    if (r - l < resR - resL) {
                        resL = l;
                        resR = r;
                    }
                }

                continue;
            } else if (l == r) {
                char add = s.charAt(r++);
                f2[add - 'A'] += 1;
            } else {
                if (isValid(f1, f2)) {
                    if (r - l < resR - resL) {
                        resL = l;
                        resR = r;
                    }

                    char delete = s.charAt(l++);
                    f2[delete -'A'] -= 1;
                } else {
                    char add = s.charAt(r++);
                    f2[add -'A'] += 1;
                }
            }

            if (resR - resL == 1) {
                break;
            }
        }

        return resR == Integer.MAX_VALUE ? "" : s.substring(resL, resR);
    }

    // f1 is target (t), f2 is test
    boolean isValid(short[] f1, short[] f2) {
        for (int i = 0; i < 64; i++) {
            if (f2[i] < f1[i]) {
                return false;
            }
        }

        return true;
    }
}