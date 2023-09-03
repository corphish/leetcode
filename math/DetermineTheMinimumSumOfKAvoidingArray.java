// https://leetcode.com/problems/determine-the-minimum-sum-of-a-k-avoiding-array/
class Solution {
    public int minimumSum(int n, int k) {
        int sum = 0;
        Set<Integer> avoid = new HashSet<>();

        for (int i = 1, cnt = 0; cnt < n; i++) {
            if (avoid.contains(i)) {
                continue;
            }

            sum += i;
            avoid.add(k - i);
            cnt += 1;
        }

        return sum;
    }
}