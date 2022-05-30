// https://leetcode.com/problems/valid-parentheses/
class Solution {
    public boolean isValid(String s) {
        int a = 0, b = 0, c = 0;
        Stack<Character> stack = new Stack<>();
        for (char ch: s.toCharArray()) {
            if (ch == '(') {
                a++;
                stack.push(ch);
            }
            
            if (ch == ')') {
                if (stack.isEmpty()) return false;
                if (stack.pop() != '(') return false;
                a--;
            }
            
            if (ch == '[') {
                b++;
                stack.push(ch);
            }
            
            if (ch == ']') {
                if (stack.isEmpty()) return false;
                if (stack.pop() != '[') return false;
                b--;
            }
            
            if (ch == '{') {
                c++;
                stack.push(ch);
            }
            
            if (ch == '}') {
                if (stack.isEmpty()) return false;
                if (stack.pop() != '{') return false;
                c--;
            }
            
            if (a < 0 || b < 0 || c < 0) return false;
        }
        
        return a + b + c == 0;
    }
}