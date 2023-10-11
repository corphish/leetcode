// https://leetcode.com/problems/smallest-subsequence-of-distinct-characters
class Solution {
    public String smallestSubsequence(String s) {
        int[] alpha = new int[26];
        HashMap<Character, Integer> map =  new HashMap<>();
        Stack<Character> stack = new Stack<>();
        
        for(int i = 0; i < s.length(); i++) map.put(s.charAt(i), i);
        
        for(int i = 0; i < s.length(); i++){
            char curr = s.charAt(i);
			
            if(alpha[curr - 'a'] == 1) continue;
			
            while(!stack.isEmpty() && curr < stack.peek() && i < map.get(stack.peek())){
                alpha[stack.pop() - 'a'] = 0;
            }
            stack.push(curr);
            alpha[curr - 'a'] = 1;
        }
        
        StringBuilder sb = new StringBuilder();   
        while(!stack.isEmpty()) sb.append(stack.pop());
        return sb.reverse().toString();
    }
}