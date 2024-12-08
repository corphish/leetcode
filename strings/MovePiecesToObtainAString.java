// https://leetcode.com/problems/move-pieces-to-obtain-a-string
class Solution {
    public boolean canChange(String start, String target) {
        int n = target.length();
        boolean l = check(start, target, 'L', 0, 1, n);
        
        if (l) {
            // Looks like we have to actually swap
            char[] arr = start.toCharArray();
            for (int i = 0; i < n; i++) {
                if (target.charAt(i) == 'L') {
                    arr[i] = 'l';
                }
            }

            for (int i = 0; i < n; i++) {
                if (arr[i] == 'L') {
                    arr[i] = '_';
                } else if (arr[i] == 'l') {
                    arr[i] = 'L';
                }
            }

            start = new String(arr);
        } else {
            return false;
        }
        
        return check(start, target, 'R', n - 1, -1, -1);
    }

    boolean check(
        String start, String target,
        char ch,
        int st, int dir, int init // init = first index of character in target which is not found
    ) {
        int n = start.length();
        int other = init; // Index of other char
        int t = next(target, dir == 1 ? -1 : n, ch, dir);

        for (int i = st; i < n && i >= 0; i += dir) {
            //System.out.printf("i=%d, t=%d, other=%d\n", i, t, other);
            if (start.charAt(i) == ch) {
                if (dir == 1) {
                    // If target is to right, we cannot go there
                    if (t > i) {
                        return false;
                    }

                    // If there is other ch in between current and target
                    if (other >= t && other <= i) {
                        return false;
                    }

                    t = next(target, t, ch, dir);
                } else {
                    // If target is to left, we cannot go there
                    if (t < i) {
                        return false;
                    }

                    // If there is other ch in between current and target
                    if (other <= t && other >= i) {
                        return false;
                    }

                    t = next(target, t, ch, dir);
                }
            } else if (start.charAt(i) != '_') {
                // Other char
                other = i;
            }
        }

        return t < 0 || t == n;
    }

    int next(String s, int startEx, char c, int dir) {
        int i = startEx + dir;
        for (; i < s.length() && i >= 0; i += dir) {
            if (s.charAt(i) == c) {
                break;
            }
        }

        return i;
    }
}