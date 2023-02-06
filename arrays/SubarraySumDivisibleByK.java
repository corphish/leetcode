// https://leetcode.com/problems/subarray-sums-divisible-by-k/submissions/881384455/
class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int[] prefix = nums.clone();
        int count = 0;
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 1; i < nums.length; i++) {
            prefix[i] += prefix[i - 1];
        }

        for (int i = 0; i < nums.length; i++) {
            int q = prefix[i] % k;
            if (q < 0) q += k;
            map.computeIfAbsent(q, f -> new ArrayList<>()).add(i);
        }

        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                List<Integer> l = map.get(0);
                if (l != null) count += l.size();
            } else {
                int q = prefix[i - 1] % k;
                if (q < 0) q += k;
                List<Integer> l = map.get(q);
                if (l != null) {
                    int ix = Collections.binarySearch(l, i);
                    if (ix < 0) ix = -ix - 1;
                    count += l.size() - ix;
                }
            }
        }

        return count;
    }
}