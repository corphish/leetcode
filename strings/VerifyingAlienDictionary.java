// https://leetcode.com/problems/verifying-an-alien-dictionary
class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        String[] sorted = words.clone();
        Arrays.sort(sorted, (a, b) -> {
            for (int i = 0; i < Math.max(a.length(), b.length()); i++) {
                if (i < a.length() && i < b.length()) {
                    char x = a.charAt(i), y = b.charAt(i);
                    if (x != y) {
                        return order.indexOf(x) - order.indexOf(y);
                    }
                }
                
                if (i >= a.length()) {
                    return -1;        
                }
                
                if (i >= b.length()) {
                    return 1;
                }
            }
            
            return 0;
        });
        
        return Arrays.equals(words, sorted);
    }
}