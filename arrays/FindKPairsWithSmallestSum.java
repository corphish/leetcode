// https://leetcode.com/problems/find-k-pairs-with-smallest-sums
class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        int m = nums2.length;
        int validStartIndex = 0;

        int[] indexes = new int[n];
        List<List<Integer>> res = new ArrayList<>();

        Arrays.fill(indexes, -1);

        while (k-- > 0) {
            int i1 = -1, i2 = -1;
            for (int i = validStartIndex; i < n; i++) {
                if (indexes[i] == m - 1) {
                    validStartIndex = i + 1;
                    continue;
                }

                if (i1 == -1 && i2 == -1) {
                    i1 = i;
                    i2 = indexes[i] + 1;
                } else {
                    if (nums1[i1] + nums2[i2] > nums1[i] + nums2[indexes[i] + 1]) {
                        i1 = i;
                        i2 = indexes[i] + 1;
                    }
                }

                if (indexes[i] == -1) break;
            }

            if (i1 == -1 && i2 == -1) break;

            res.add(Arrays.asList(nums1[i1], nums2[i2]));
            indexes[i1] = i2;
        }

        return res;
    }
}