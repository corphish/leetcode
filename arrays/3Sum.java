// Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
// Notice that the solution set must not contain duplicate triplets.
class Solution {
    // For every pair in nums(i, j), check if -(nums[i] + nums[j]) is present or not, if yes, add to result.
    // Take help of set to maintain unique values in result.
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Map<Integer, Integer> freq = new HashMap<>();
        Set<String> keys = new HashSet<>();
        
        Arrays.sort(nums);
        
        for (int x: nums) {
            freq.put(x, freq.getOrDefault(x, 0) + 1);
        }
        
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int req = -(nums[i] + nums[j]);
                int count = freq.getOrDefault(req, 0) - (nums[i] == req ? 1 : 0) - (nums[j] == req ? 1 : 0);
                
                int[] keyArr = {nums[i], nums[j], req};
                Arrays.sort(keyArr);
                String key = keyArr[0] + "," + keyArr[1] + "," + keyArr[2];                
                
                if (count >= 1 && keys.add(key)) {
                    res.add(List.of(nums[i], nums[j], req));
                } 
            }
        }
        
        return res;
    }
}