// https://leetcode.com/problems/find-the-difference-of-two-arrays
class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        List<Integer> r1 = new ArrayList<>();
        List<Integer> r2 = new ArrayList<>();

        Set<Integer> s1 = new HashSet<>();
        Set<Integer> s2 = new HashSet<>();

        for (int x: nums1) s1.add(x);
        for (int x: nums2) s2.add(x);

        for (int x: s1) if (!s2.contains(x)) r1.add(x);
        for (int x: s2) if (!s1.contains(x)) r2.add(x);

        return Arrays.asList(r1, r2);
    }
}