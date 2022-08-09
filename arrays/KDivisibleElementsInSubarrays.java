// https://leetcode.com/problems/k-divisible-elements-subarrays
class Solution {
    // Check all subarrays if they are matching the criteria.
    // Store the valid subarray in a set to avoid duplicates.
    public int countDistinct(int[] nums, int k, int p) {
        int n = nums.length, count = 0;
        Set<String> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            int subCount = 0;
            StringBuilder hash = new StringBuilder();
            
            for (int j = i; j < n; j++) {
                if (subCount > k) {
                    break;
                }
                
                hash.append(nums[j] + ",");
                
                subCount += nums[j] % p == 0 ? 1 : 0;
                if (subCount <= k && set.add(hash.toString())) {
                    //System.out.println("Adding i=" + i + ", j=" + j);
                    count++;
                }
            }
        }
        
        return count;
    }
}