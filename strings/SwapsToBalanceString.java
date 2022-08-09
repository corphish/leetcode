// https://leetcode.com/problems/minimum-number-of-swaps-to-make-the-string-balanced
class Solution {
    // When we encounter the count as than 1, we swap with the farthest [ and count the swap
    // After this operation, we make the count 1
    public int minSwaps(String s) {
        char[] c = s.toCharArray();
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i < c.length; i++) {
            if (c[i] == '[') {
                stack.push(i);
            }
        }
        
        int count = 0, swaps = 0;
        for (int i = 0; i < c.length; i++) {
            char a = c[i];
            if (a == '[') {
                count++;
            } else {
                count--;
                
                if (count < 0) {
                    count = 1;
                    swaps++;
                    
                    int last = stack.pop();
                    c[last] = ']';
                    c[i] = '[';
                    
                    //System.out.println(Arrays.toString(c) + ", " + stack);
                }
            }
        }
        
        return swaps;
    }
}