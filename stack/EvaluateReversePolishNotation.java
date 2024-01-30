// https://leetcode.com/problems/evaluate-reverse-polish-notation
class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String token: tokens) {
            if ("+".equals(token)) {
                int a = stack.pop();
                int b = stack.pop();
                stack.push(a + b);
            } else if ("-".equals(token)) {
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b - a);
            } else if ("*".equals(token)) {
                int a = stack.pop();
                int b = stack.pop();
                stack.push(a * b);
            } else if ("/".equals(token)) {
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b / a);
            } else {
                stack.push(Integer.parseInt(token));
            }
        }

        return stack.pop();
    }
}