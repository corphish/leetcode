class Solution {
    // Logic: Taking each element in the array, product it till the end and note the max.
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int max = Integer.MIN_VALUE;
        
        for (int i = 0; i < n; i++) {
            //System.out.println("Starting " + nums[i]);
            int p = nums[i];
            max = Math.max(p, max);
            for (int j = i + 1; j < n; j++) {
                p *= nums[j];
                //System.out.println(p);
                max = Math.max(p, max);
            }
        }
        
        return max;
    }
}