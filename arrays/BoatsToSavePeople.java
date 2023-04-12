// https://leetcode.com/problems/boats-to-save-people/
class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        
        int count = 0, weight = 0;
        int l = 0, r = people.length - 1;
        
        // Logic: Put the heaviest one available first.
        // Then see if we can put the lighest one available.
        for (; l <= r; r--, count++) {
            weight = people[r];
            if (weight + people[l] <= limit) {
                l++;
            }
        }
        
        return count;
    }
}