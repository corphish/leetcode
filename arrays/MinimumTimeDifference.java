// https://leetcode.com/problems/minimum-time-difference/
class Solution {
    public int findMinDifference(List<String> timePoints) {
        int min = Integer.MAX_VALUE;
        List<Integer> minutes = new ArrayList<>();

        for (String t: timePoints) {
            int m = minutes(t);
            minutes.add(m);
            minutes.add(1440 + m);
        }

        Collections.sort(minutes);
        for (int i = 1; i < minutes.size(); i++) {
            min = Math.min(min, minutes.get(i) - minutes.get(i - 1));
        }

        return min;
    }

    int minutes(String x) {
        String[] parts = x.split(":");
        return Integer.parseInt(parts[0]) * 60 + Integer.parseInt(parts[1]);
    }
}