// https://leetcode.com/problems/array-of-doubled-pairs/
class Solution {
    public boolean canReorderDoubled(int[] arr) {
        arr = Arrays.stream(arr)
                .boxed()
                .sorted((a, b) -> Math.abs(a) - Math.abs(b))
                .mapToInt(i -> i)
                .toArray();
        
        final int offset = 400000;
        int[] freq = new int[2 * offset + 1];
        
        for (int x: arr) {
            freq[x + offset]++;
        }
        
        for (int x: arr) {
            int e1 = x + offset;
            int e2 = (2 * x) + offset;
            
            if (freq[e1] > 0 && freq[e2] > 0) {
                freq[e1]--;
                freq[e2]--;
            }
            
            
        }
        
        int count = 0;
        for (int x: freq) {
            count += x;
            if (x < 0) return false;
        }
        
        return count == 0;
    }
}