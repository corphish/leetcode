// https://leetcode.com/problems/alert-using-same-key-card-three-or-more-times-in-a-one-hour-period
class Solution {
    public List<String> alertNames(String[] keyName, String[] keyTime) {
        Map<String, List<Integer>> map = new TreeMap<>();
        for (int i = 0; i < keyName.length; i++) {
            map.computeIfAbsent(keyName[i], x -> new ArrayList<>()).add(parseTime(keyTime[i]));
        }

        List<String> res = new ArrayList<>();
        for (var e: map.entrySet()) {
            List<Integer> times = e.getValue();
            Collections.sort(times);
            for (int i = 0; i < times.size() - 2; i++) {
                if (times.get(i + 2) - times.get(i) <= 60) {
                    res.add(e.getKey());
                    break;
                }
            }
        }

        return res;
    }

    int parseTime(String time) {
        String[] parts = time.split(":");
        return Integer.parseInt(parts[0]) * 60 + Integer.parseInt(parts[1]);
    }
}