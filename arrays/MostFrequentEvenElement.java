// https://leetcode.com/problems/most-frequent-even-element
class Solution {
    public int mostFrequentEven(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int x: nums) {
            if (x % 2 == 0) {
                freq.put(x, freq.getOrDefault(x, 0) + 1);
            }
        }
        
        int val = -1, max = 0;
        for (var e: freq.entrySet()) {
            if (e.getValue() > max || (e.getValue() == max && e.getKey() < val)) {
                max = e.getValue();
                val = e.getKey();
            }
        }
        
        return val;
    }
}