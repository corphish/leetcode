// https://leetcode.com/problems/sum-of-floored-pairs
class Solution {
    public int sumOfFlooredPairs(int[] nums) {
        Arrays.sort(nums);
        
        int min = Integer.MAX_VALUE, max = 0, i = 0;
        
        int[] freq = new int[100001];
        
        int[] minIndex = new int[100001];
        int[] maxIndex = new int[100001];
        long[] sums = new long[100001];
        
        Arrays.fill(minIndex, -1);
        Arrays.fill(maxIndex, -1);
        Arrays.fill(sums, -1);
        
        for (int x: nums) {
            min = Math.min(min, x);
            max = Math.max(max, x);
            freq[x]++;
            
            if (minIndex[x] == -1) {
                minIndex[x] = i;
            }
            
            maxIndex[x] = i;
            i++;
        }
        
        int factor = max/min + 1;
        long sum = 0;
        
        for (i = 0; i < nums.length; i++) {
            int x = nums[i];
            
            //System.out.printf("sums[%d] = %d\n", x, sums[x]);
            
            if (sums[x] >= 0) {
                sum += sums[x];
                continue;
            }
            
            long numSum = 0;
            //System.out.printf("Checking nums[%d] = %d\n", i, x);
            for (int j = 2; j <= factor && x * (j - 1) <= max; j++) {
                boolean endExceedsMax = false;
                int startNum = x * (j - 1);
                int endNum = (x * j) - 1;
                
                if (endNum > max) {
                    endNum = max;
                    endExceedsMax = true;
                }
                
                long count = 0;
                
                // If both startNum and endNum are present in arr
                if (minIndex[startNum] >= 0 && maxIndex[endNum] >= 0) {
                    count = maxIndex[endNum] - minIndex[startNum] + 1;
                } else if (minIndex[startNum] >= 0) {
                    int ix = Arrays.binarySearch(nums, endNum);
                    count = (-ix - 1) - minIndex[startNum];
                } else if (maxIndex[endNum] >= 0) {
                    int ix = Arrays.binarySearch(nums, startNum);
                    ix = -ix - 1;
                    count = maxIndex[endNum] - ix + 1;
                } else {
                    int ix1 = Arrays.binarySearch(nums, startNum);
                    int ix2 = Arrays.binarySearch(nums, endNum);
                    
                    ix1 = -ix1 - 1;
                    ix2 = -ix2 - 1;
                    
                    count = ix2 - ix1;
                }
                
                //System.out.printf("Factor = %d, startNum = %d, endNum = %d, count = %d\n", j - 1, startNum, endNum, count);
                
                numSum += (j - 1) * count;
                sum += (j - 1) * count;
                
                if (endExceedsMax) break;
            }
            
            sums[x] = numSum;
        }
        
        return (int) (sum % 1000000007);
    }
}