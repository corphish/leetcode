// https://leetcode.com/problems/binary-subarrays-with-sum
class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int count = 0;
        int[] prefix = nums.clone();
        Map<Integer, List<Integer>> map = new HashMap<>();

        map.computeIfAbsent(nums[0], x -> new ArrayList<>()).add(0);

        for (int i = 1; i < nums.length; i++) {
            prefix[i] += prefix[i - 1];
            map.computeIfAbsent(prefix[i], x -> new ArrayList<>()).add(i);
        }

        for (int i = 0; i < nums.length; i++) {
            int target = goal + prefix[i] - nums[i];
            List<Integer> l = map.get(target);

            if (l != null) {
                int ix = Collections.binarySearch(l, i);
                if (ix < 0) ix = -ix - 1;
                count += l.size() - ix;
            }
        }

        return count;
    }

    int prefixSum(int[] nums, int goal) {
        int count = 0;
        int[] prefix = nums.clone();
        Map<Integer, List<Integer>> map = new HashMap<>();

        map.computeIfAbsent(nums[0], x -> new ArrayList<>()).add(0);

        for (int i = 1; i < nums.length; i++) {
            prefix[i] += prefix[i - 1];
            map.computeIfAbsent(prefix[i], x -> new ArrayList<>()).add(i);
        }

        for (int i = 0; i < nums.length; i++) {
            int target = goal + prefix[i] - nums[i];
            List<Integer> l = map.get(target);

            if (l != null) {
                int ix = Collections.binarySearch(l, i);
                if (ix < 0) ix = -ix - 1;
                count += l.size() - ix;
            }
        }

        return count;
    }
}