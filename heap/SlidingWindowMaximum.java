// https://leetcode.com/problems/sliding-window-maximum
class Solution {
    // We create a treeset and a model that holds index and val so that the duplicate elements can be stored in the set.
    // In each window we add the max element in the set to the result, and then in each slide, we remove the first item (index)
    // wise from the set and add the i + kth one.
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];
        TreeSet<Data> max = new TreeSet<>();
        int i;
        
        for (i = 0; i < k; i++) {
            max.add(new Data(nums[i], i));
        }
        
        for (i = 0; i < nums.length - k; i++) {
            if (i > 0) {
                
            }
            
            res[i] = max.first().val;
            
            max.remove(new Data(nums[i], i));
            max.add(new Data(nums[i + k], i + k));
        }
        
        res[i] = max.first().val;
        
        return res;
    }
    
    class Data implements Comparable<Data> {
        int val, index;
        
        Data(int val, int index) {
            this.val = val;
            this.index = index;
        }
        
        public int compareTo(Data other) {
            return this.val == other.val ? this.index - other.index : other.val - this.val;
        }
        
        public String toString() {
            return "{val=" + val + ", index=" + index + "}"; 
        }
    }
}