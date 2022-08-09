// https://leetcode.com/problems/rearrange-spaces-between-words/
class Solution {
    public String reorderSpaces(String text) {
        String[] words = text.trim().split("[ ]{1,}");
        int totalSpaces = 0;
        
        for (char c: text.toCharArray()) {
            if (c == ' ') {
                totalSpaces++;
            }
        }
        
        //System.out.println(Arrays.toString(words));
        
        // If there are n words, we can have n - 1 spaces between them
        // Now these (n - 1) space groups can have multiple spaces
        // We also have to account for extra spaces that needs to be added in the end.
        int extraSpaces = words.length == 1 ? totalSpaces : totalSpaces % (words.length - 1);
        int spaceDistribution = words.length == 1 ? 0 : totalSpaces/(words.length - 1);
        
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < words.length - 1; i++) {
            sb.append(words[i]);
            addSpaces(sb, spaceDistribution);
        }
        
        sb.append(words[words.length - 1]);
        addSpaces(sb, extraSpaces);
        
        return sb.toString();
    }
    
    void addSpaces(StringBuilder sb, int n) {
        for (int i = 0; i < n; i++) {
            sb.append(' ');
        }
    }
}