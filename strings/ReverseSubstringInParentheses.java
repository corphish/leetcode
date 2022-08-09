// https://leetcode.com/problems/reverse-substrings-between-each-pair-of-parentheses
class Solution {
    public String reverseParentheses(String s) {
        String res = s;
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(i);
            } else if (c == ')') {
                int start = stack.pop();
                res = res.substring(0, start + 1) + new StringBuffer(res.substring(start + 1, i)).reverse() + res.substring(i);
            }
        }
        
        return res.replace("(", "").replace(")", "");
    }
}