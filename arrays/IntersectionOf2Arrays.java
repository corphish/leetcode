// https://leetcode.com/problems/intersection-of-two-arrays
class Solution {
    // Problem is to:
    // 1. Find if an element is present in both the arrays.
    // 2. If step 1 is satisfied, add the element in to the result.
    public int[] intersection(int[] nums1, int[] nums2) {
        Map<Integer, Integer> freq1 = new HashMap<>();
        Map<Integer, Integer> freq2 = new HashMap<>();
        
        for (int x: nums1) {
            freq1.put(x, freq1.getOrDefault(x, 0) + 1);
        }
        
        for (int x: nums2) {
            freq2.put(x, freq2.getOrDefault(x, 0) + 1);
        }
        
        List<Integer> res = new ArrayList<>();
        for (int x: freq1.keySet()) {
            int min = Math.min(freq1.get(x), freq2.getOrDefault(x, 0));
            if (min > 0) res.add(x);
        }
        
        return res.stream().mapToInt(x -> x).toArray();
    }
}