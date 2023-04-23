// https://leetcode.com/problems/kids-with-the-greatest-number-of-candies
class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = 0;
        List<Boolean> res = new ArrayList<>();
        
        for (int x: candies) max = Math.max(x, max);
        for (int x: candies) res.add(x + extraCandies >= max);
        
        return res;
    }
}