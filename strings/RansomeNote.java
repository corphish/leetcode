class Solution {
    public boolean canConstruct(String a, String b) {
        int[] freq = new int[128];
        for (char c: a.toCharArray()) {
            freq[c]++;
        }
        
        for (char c: b.toCharArray()) {
            freq[c]--;
            freq[c] = Math.max(0, freq[c]);
        }
        
        int count = 0;
        for (int x: freq) count += x;
        
        return count == 0;
    }
}