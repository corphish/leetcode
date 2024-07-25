// https://leetcode.com/problems/maximum-score-from-removing-substrings
class Solution {
    public int maximumGain(String s, int x, int y) {
        int points = 0, del = 0;
        Stack<Character> stack = new Stack<Character>();
        StringBuilder sb = new StringBuilder();

        do {
            del = 0;
            stack.clear();

            // Delete the one with greater score
            for (char c: s.toCharArray()) {
                if (stack.isEmpty()) {
                    stack.push(c);
                } else {
                    if (x > y) {
                        // ab
                        if (c == 'b' && stack.peek() == 'a') {
                            stack.pop();
                            points += x;
                            del += 1;
                        } else {
                            stack.push(c);
                        }
                    } else {
                        // ba
                        if (c == 'a' && stack.peek() == 'b') {
                            stack.pop();
                            points += y;
                            del += 1;
                        } else {
                            stack.push(c);
                        }
                    }
                }
            }

            sb.setLength(0);
            for (char c: stack) {
                sb.append(c);
            }
            s = sb.toString();

            stack.clear();

            // Delete the one with lesser score
            for (char c: s.toCharArray()) {
                if (stack.isEmpty()) {
                    stack.push(c);
                } else {
                    if (y > x) {
                        // ab
                        if (c == 'b' && stack.peek() == 'a') {
                            stack.pop();
                            points += x;
                            del += 1;
                        } else {
                            stack.push(c);
                        }
                    } else {
                        // ba
                        if (c == 'a' && stack.peek() == 'b') {
                            stack.pop();
                            points += y;
                            del += 1;
                        } else {
                            stack.push(c);
                        }
                    }
                }
            }

            sb.setLength(0);
            for (char c: stack) {
                sb.append(c);
            }
            s = sb.toString();
        } while (del > 0);

        return points;
    }
}