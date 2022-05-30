class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        List<Integer> list = new ArrayList<>();
        
        Arrays.sort(nums);
        
        // First run
        int ix = binarySearch(nums, target);
        
        if (ix < 0) {
            return list;
        } else {
            list.add(ix);
            for (int i = ix - 1; i >= 0 && nums[i] == target; i--) {
                list.add(0, i);
            }
            
            for (int i = ix + 1; i < nums.length && nums[i] == target; i++) {
                list.add(i);
            }
        }
        
        return list;
    }
    
    int binarySearch(int[] arr, int target) {
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high)/2;
            if (arr[mid] == target) {
                return mid;
            }
            
            if (target < arr[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        
        return -1;
    }
}