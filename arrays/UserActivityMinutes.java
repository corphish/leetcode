// https://leetcode.com/problems/finding-the-users-active-minutes
class Solution {
    // Create 2 maps, 1 will store set of all the timestamps of user activity agains the user id.
    // The other one will store the number of uam (key is the size, value is the number of users (set from the previous map) whose uam size is that of key)
    public int[] findingUsersActiveMinutes(int[][] logs, int k) {
        Map<Integer, Set<Integer>> userActivity = new HashMap<>();
        Map<Integer, Integer> uamCount = new HashMap<>();
        
        int[] res = new int[k];
        
        for (int[] log: logs) {
            Set<Integer> set = userActivity.getOrDefault(log[0], new HashSet<>());
            set.add(log[1]);
            userActivity.put(log[0], set);
        }
        
        for (var act: userActivity.values()) {
            uamCount.put(act.size(), uamCount.getOrDefault(act.size(), 0) + 1);
        }
        
        for (int i = 0; i < k; i++) {
            res[i] = uamCount.getOrDefault(i + 1, 0);
        }
        
        return res;
    }
}