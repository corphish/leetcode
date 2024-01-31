// https://leetcode.com/problems/maximum-equal-frequency
class Solution {
    public int maxEqualFreq(int[] nums) {
        int res = 2;
        Map<Integer, Integer> freq = new HashMap<>();
        TreeMap<Integer, List<Integer>> rev = new TreeMap<>();

        for (int i = 0; i < nums.length; i++) {
            int x = nums[i];
            int currFreq = freq.getOrDefault(x, 0);
            freq.put(x, currFreq + 1);
            List<Integer> list = rev.get(currFreq);
            if (list != null) {
                list.remove(new Integer(x));
                if (list.isEmpty()) {
                    rev.remove(currFreq);
                }
            }

            list = rev.get(currFreq + 1);
            if (list == null) {
                list = new ArrayList<>();
            }

            list.add(x);
            rev.put(currFreq + 1, list);

            if (rev.size() == 2) {
                // If we have an entry with freq 1 we delete it
                if (rev.firstKey() == 1 && rev.firstEntry().getValue().size() == 1) {
                    res = Math.max(res, i + 1);
                }

                if (rev.firstKey() == rev.lastKey() - 1 && rev.lastEntry().getValue().size() == 1) {
                    res = Math.max(res, i + 1);
                }
            } else if (rev.size() == 1 && rev.firstKey() == 1) {
                res = Math.max(res, i + 1);
            } else if (freq.size() == 1) {
                res = Math.max(res, i + 1);
            }
        }

        return res;
    }
}