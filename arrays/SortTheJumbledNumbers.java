// https://leetcode.com/problems/sort-the-jumbled-numbers/
class Solution {
    public int[] sortJumbled(int[] mapping, int[] nums) {
        return Arrays.stream(nums)
                .boxed()
                .sorted((a, b) -> jumble(a, mapping) - jumble(b, mapping))
                .mapToInt(i -> i)
                .toArray();
    }

    int jumble(int x, int[] map) {
        int res = 0, k = 1;
        
        if (x == 0) {
            return map[x];
        }

        while (x > 0) {
            int r = x % 10;
            res += k * map[r];
            k *= 10;
            x /= 10;
        }
        
        return res;
    }
}