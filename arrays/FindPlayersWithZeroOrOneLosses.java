// https://leetcode.com/problems/find-players-with-zero-or-one-losses/
class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        Set<Integer> players = new TreeSet<>();
        Map<Integer, Integer> defeats = new HashMap<>();

        for (int[] match: matches) {
            players.add(match[0]);
            players.add(match[1]);

            defeats.put(match[1], defeats.getOrDefault(match[1], 0) + 1);
        }

        return List.of(
            players.stream().filter(x -> !defeats.keySet().contains(x)).collect(Collectors.toList()),
            defeats.entrySet().stream().filter(x -> x.getValue() == 1).map(x -> x.getKey()).sorted().collect(Collectors.toList())
        );
    }
}