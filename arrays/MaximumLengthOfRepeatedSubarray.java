// https://leetcode.com/problems/maximum-length-of-repeated-subarray/
class Solution {
    public int findLength(int[] nums1, int[] nums2) {
        Map<Integer, List<Integer>> indexMap = new HashMap<>();
        int max = 0;
        
        for (int i = 0; i < nums2.length; i++) {
            indexMap.computeIfAbsent(nums2[i], x -> new ArrayList<>()).add(i);
        }
        
        for (int i = 0; i < nums1.length; i++) {
            int x = nums1[i];
            List<Integer> indexes = indexMap.get(x);
            
            if (indexes != null && indexes.size() > 0) {
                for (int ix: indexes) {
                    if (ix + max >= nums2.length) break;
                    int len = 0;
                    for (int j = i, k = ix; j < nums1.length && k < nums2.length; j++, k++) {
                        if (nums1[j] != nums2[k]) {
                            break;
                        }
                        
                        len++;
                    }
                    
                    max = Math.max(max, len);
                    if (len == nums1.length || len == nums2.length) {
                        return len;
                    }
                }
            }
        }
        
        return max;
    }
}