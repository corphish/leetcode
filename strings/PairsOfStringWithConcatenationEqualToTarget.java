// https://leetcode.com/problems/number-of-pairs-of-strings-with-concatenation-equal-to-target
class Solution {
    public int numOfPairs(String[] nums, String target) {
        int targetLen = target.length();
        Map<Integer, List<IndexedPair<String>>> map = new HashMap<>();

        int i = 0;
        for (String x: nums) {
            map.computeIfAbsent(x.length(), b -> new ArrayList<>()).add(new IndexedPair(i++, x));
        }

        int count = 0;
        i = 0;
        for (String x: nums) {
            int req = targetLen - x.length();
            List<IndexedPair<String>> list = map.get(req);
            if (list != null) {
                for (IndexedPair<String> y: list) {
                    if (i != y.index && (x + y.val).equals(target)) {
                        count += 1;
                    }
                }
            }

            i++;
        }

        return count;
    }

    class IndexedPair<T> {
        int index;
        T val;

        IndexedPair(int index, T val) {
            this.index = index;
            this.val = val;
        }
    }
}