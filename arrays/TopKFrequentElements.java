// https://leetcode.com/problems/top-k-frequent-elements
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        TreeMap<Integer, List<Integer>> rev = new TreeMap<>((a, b) -> b - a);
        for (int x: nums) {
            int freq = map.getOrDefault(x, 0) + 1;
            map.put(x, freq);
        }
        
        int count = 0, res[] = new int[k];
        for (Map.Entry<Integer, Integer> e: map.entrySet()) {
            List<Integer> l = rev.getOrDefault(e.getValue(), new ArrayList<>());
            l.add(e.getKey());
            rev.put(e.getValue(), l);
        }
        
        for (Map.Entry<Integer, List<Integer>> e: rev.entrySet()) {
            for (int x: e.getValue()) {
                res[count++] = x;
                if (count >= res.length) return res;
            }
        }
        
        return res;
    }
}