// https://leetcode.com/problems/kth-largest-element-in-a-stream
class KthLargest {
    
    TreeSet<Integer> set;
    Map<Integer, Integer> freq;
    int k = 0, count = 0;

    public KthLargest(int k, int[] nums) {
        set = new TreeSet<>();
        freq = new HashMap<>();
        this.k = k;
        
        Arrays.sort(nums);
        
        if (nums.length != 0 && k <= nums.length) {
            for (int i = nums.length - k; i < nums.length; i++) {
                set.add(nums[i]);
                freq.put(nums[i], freq.getOrDefault(nums[i], 0) + 1);
                count++;
            }
        } else {
            for (int i = 0; i < nums.length; i++) {
                set.add(nums[i]);
                freq.put(nums[i], freq.getOrDefault(nums[i], 0) + 1);
                count++;
            }
        }
        
        
    }
    
    public int add(int val) {
        if (set.isEmpty()) {
            set.add(val);
            freq.put(val, 1);
            count++;
            return val;
        }
        
        if (k > count) {
            set.add(val);
            freq.put(val, freq.getOrDefault(val, 0) + 1);
            count++;
            return set.first();
        }
        
        int f = set.first();
        if (val > f) {
            int firstFreq = freq.get(f);
            if (firstFreq == 1) {
                set.remove(f);
            } else {
                freq.put(f, firstFreq - 1);
            }
            
            set.add(val);
            freq.put(val, freq.getOrDefault(val, 0) + 1);
            
            /*if (set.first() != val) {
                set.add(f);
            }*/
        }
        //System.out.println(set);
        return set.first();
    }
}