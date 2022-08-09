// https://leetcode.com/problems/remove-outermost-parentheses
class Solution {
    // Maintain a count variable, increase it by 1 for ( and decrease for ).
    // Track the start.
    // When count reaches 0, add s[start + 1..i - 1], and set start to i + 1.
    public String removeOuterParentheses(String s) {
        int count = 0, i = 0;
        int start = 0;
        StringBuilder sb = new StringBuilder();
        
        
        for (char c: s.toCharArray()) {
            count += c == '(' ? 1 : -1;
            if (count == 0) {
                sb.append(s.substring(start + 1, i));
                start = i + 1;
            }
            i++;
        }
        
        return sb.toString();
    }
}