// https://leetcode.com/problems/string-compression/
class Solution {
    public int compress(char[] chars) {
        int w = 0, r = 0, count = 0;
        char last = 0;

        for (; r < chars.length; r++) {
            if (last == 0) {
                last = chars[r];
                count = 1;
            } else {
                if (chars[r] == last) {
                    count++;
                } else {
                    chars[w++] = last;
                    if (count > 1) {
                        w += writeSize(chars, count, w);
                    }

                    count = 1;
                    last = chars[r];
                }
            }
        }

        if (count > 1) {
            chars[w++] = last;
            w += writeSize(chars, count, w);
        } else {
            chars[w++] = last;
        }

        return w;
    }

    int writeSize(char[] arr, int size, int start) {
        Stack<Integer> stack = new Stack<>();
        while (size > 0) {
            stack.push(size % 10);
            size /= 10;
        }

        int res = stack.size();

        while (!stack.isEmpty()) {
            arr[start++] = (char) (stack.pop() + '0');
        }

        return res;
    }
}