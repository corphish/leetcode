// https://leetcode.com/problems/number-of-matching-subsequences/
class Solution {
    public int numMatchingSubseq(String s, String[] words) {
        Subsequencer sb = new Subsequencer(s);
        int count = 0;
        
        for (String word: words) {
            if (sb.isSubsequence(word)) {
                count++;
            }
        }
        
        return count;
    }
    
    class Subsequencer {
        private int[][] indexMap;
        private int[] indexTrack;
        
        Subsequencer(String s) {
            indexMap = new int[26][s.length()];
            indexTrack = new int[26];
            
            for (int[] row: indexMap) {
                Arrays.fill(row, Integer.MAX_VALUE);
            }
            
            for (int i = 0; i < s.length(); i++) {
                int index = s.charAt(i) - 'a';
                indexMap[index][indexTrack[index]++] = i;
            }
        }
        
        boolean isSubsequence(String w) {
            int track = -1;
            for (int x: w.getBytes()) {
                int index = x - 'a';
                int searched = Arrays.binarySearch(indexMap[index], track);
                if (searched < 0) {
                    searched = -searched - 1;
                } else {
                    searched = searched + 1;
                }
                
                if (searched >= indexMap[index].length || indexMap[index][searched] == Integer.MAX_VALUE) {
                    return false;
                } else {
                    track = indexMap[index][searched];
                }
            }
            
            return true;
        }
    }
}