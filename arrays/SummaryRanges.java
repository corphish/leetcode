// https://leetcode.com/problems/summary-ranges
class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        if (nums.length == 0) return res;
        
        long start = nums[0], last = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - last > 1) {
                if (last != start)
                    res.add(start + "->" + last);
                else
                    res.add("" + last);
                start = nums[i];
            }
            
            last = nums[i];
        }
        
        if (start == last) {
            res.add("" + last);
        } else {
            res.add(start + "->" + last);
        }
        
        return res;
    }
}