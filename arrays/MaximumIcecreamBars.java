// https://leetcode.com/problems/maximum-ice-cream-bars
class Solution {
    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        int i = 0;
        while (coins > 0 && i < costs.length) {
            if (costs[i] > coins) {
                break;
            }
            
            coins -= costs[i++];
        }
        
        return i;
    }
}