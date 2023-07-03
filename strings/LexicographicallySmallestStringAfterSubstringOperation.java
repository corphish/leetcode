// https://leetcode.com/problems/lexicographically-smallest-string-after-substring-operation/submissions/971160602/
class Solution {
    public String smallestString(String s) {
        int l = -1, r = -1;
        boolean onlyA = true;
        char last = '0';
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c != 'a') {
                onlyA = false;
            }

            if (c == 'a') {
                if (l == -1 || (r == -1 && last == 'a' && onlyA)) l = i;
                else if (r == -1) {
                    r = i;
                }
            }

            last = c;
        }

        if (onlyA) {
            return mod(s, s.length() - 1, s.length() - 1);
        } else {
            if (l != -1 && r != -1) {
                String a = mod(s, l + 1, r - 1);
                String b = mod(s, 0, l - 1);

                return a.compareTo(b) < 0 ? a : b;
            } else if (l == -1) {
                return mod(s, 0, s.length() - 1);
            } else {
                String a = mod(s, l + 1, s.length() - 1);
                String b = mod(s, 0, l - 1);

                return a.compareTo(b) < 0 ? a : b;
            }
        }
    }

    String mod(String s, int x, int y) {
        char[] arr = s.toCharArray();
        for (int i = x; i <= y; i++) {
            arr[i] = arr[i] == 'a' ? 'z' : (char) (arr[i] - 1);
        }

        return new String(arr);
    }
}