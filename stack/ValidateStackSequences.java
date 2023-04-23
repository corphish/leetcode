// https://leetcode.com/problems/validate-stack-sequences/
class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> s = new Stack<>();
        int i = 0;
        
        for (int x: popped) {
            if (!s.contains(x)) {
                for (; i < pushed.length && pushed[i] != x; i++) s.push(pushed[i]);
                if (i < pushed.length) s.push(pushed[i]);
                i++;
            }
            if (s.peek() == x) {
                int r = s.pop();
            } else return false;
        }
        
        return true;
    }
}