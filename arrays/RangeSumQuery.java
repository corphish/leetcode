// https://leetcode.com/problems/range-sum-query-immutable
class NumArray {
    int[] prefix;

    public NumArray(int[] nums) {
        prefix = nums.clone();
        for (int i = 1; i < nums.length; i++) {
            prefix[i] += prefix[i - 1];
        }
    }
    
    public int sumRange(int left, int right) {
        if (left == 0) return prefix[right];
        return prefix[right] - prefix[left - 1];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */