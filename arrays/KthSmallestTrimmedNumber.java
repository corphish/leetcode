// https://leetcode.com/problems/query-kth-smallest-trimmed-number
class Solution {
    public int[] smallestTrimmedNumbers(String[] nums, int[][] queries) {
        TrimmedValues tv = new TrimmedValues(nums);
        int[] res = new int[queries.length];
        
        for (int i = 0; i < res.length; i++) {
            res[i] = tv.getKSmallestIndexForSize(queries[i][0], queries[i][1]);
        }
        
        return res;
    }
    
    class IndexedValue implements Comparable<IndexedValue> {
        int index;
        String value;
        
        IndexedValue(String value, int index) {
            this.value = value;
            this.index = index;
        }
        
        public int compareTo(IndexedValue other) {
            int x = this.value.compareTo(other.value);
            return x == 0 ? this.index - other.index : x;
        }
        
        public String toString() {
            return value + " at " + index;
        }
    }
    
    class TrimmedValues {
        Map<Integer, List<IndexedValue>> map = new HashMap<>();
        
        TrimmedValues(String[] nums) {
            StringBuilder[] sbs = new StringBuilder[nums.length];
            int len = nums[0].length();
            
            for (int i = len - 1; i >= 0; i--) {
                for (int j = 0; j < nums.length; j++) {
                    if (sbs[j] == null) sbs[j] = new StringBuilder();
                    sbs[j].append(nums[j].charAt(i));
                }
                
                List<IndexedValue> values = new ArrayList<>();
                for (int j = 0; j < nums.length; j++) {
                    values.add(new IndexedValue(sbs[j].reverse().toString(), j));
                }
                
                for (StringBuilder sb: sbs) sb.reverse();
                
                Collections.sort(values);
                //System.out.println(values);
                map.put(len - i, values);
            }
        }
        
        int getKSmallestIndexForSize(int k, int size) {
            return map.get(size).get(k - 1).index;
        }
    }
}