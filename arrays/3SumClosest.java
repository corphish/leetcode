// https://leetcode.com/problems/3sum-closest/
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closest = 100000;
        
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int rem = target - nums[i] - nums[j];
                int ix = Arrays.binarySearch(nums, j + 1, nums.length, rem);
                if (ix < 0) ix = -ix - 1;
                if (ix == nums.length && ix - 1 > j) {
                    int sum = nums[i] + nums[j] + nums[ix - 1];
                    if (Math.abs(target - sum) < Math.abs(target - closest)) {
                        closest = sum;
                    }
                } else if (ix < nums.length) {
                    if (ix - 1 > j) {
                        int diff1 = Math.abs(target - nums[i] - nums[j] - nums[ix - 1]);
                        int diff2 = Math.abs(target - nums[i] - nums[j] - nums[ix]);
                        
                        if (diff1 < diff2) {
                            if (diff1 < Math.abs(target - closest)) {
                                closest = nums[i] + nums[j] + nums[ix - 1];
                            }
                        } else {
                            if (diff2 < Math.abs(target - closest)) {
                                closest = nums[i] + nums[j] + nums[ix];
                            }
                        }
                    } else if (ix - 1 == j) {
                        int sum = nums[i] + nums[j] + nums[ix];
                        if (Math.abs(target - sum) < Math.abs(target - closest)) {
                            closest = sum;
                        }
                    }
                }
            }
        }
        
        return closest;
    }
}