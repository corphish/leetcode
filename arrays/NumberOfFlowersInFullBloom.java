// https://leetcode.com/problems/number-of-flowers-in-full-bloom
class Solution {
    public int[] fullBloomFlowers(int[][] flowers, int[] people) {
        List<Integer> start = new ArrayList<>();
        List<Integer> end = new ArrayList<>();

        for (int[] flower: flowers) {
            start.add(flower[0]);
            end.add(flower[1] + 1);
        }

        Collections.sort(start);
        Collections.sort(end);

        Map<Integer, Integer> startLast = new HashMap<>();
        Map<Integer, Integer> endLast = new HashMap<>();

        for (int i = 0; i < start.size(); i++) {
            startLast.put(start.get(i), i);
            endLast.put(end.get(i), i);
        }

        int[] res = new int[people.length];
        for (int i = 0; i < people.length; i++) {
            int t = people[i];
            int started;
            int ended;

            if (startLast.containsKey(t)) {
                started = startLast.get(t) + 1;
            } else {
                started = Collections.binarySearch(start, people[i]);
                started = -started - 1;
            }

            if (endLast.containsKey(t)) {
                ended = endLast.get(t) + 1;
            } else {
                ended = Collections.binarySearch(end, people[i]);
                ended = -ended - 1;
            }

            res[i] = started - ended;
        }

        return res;
    }
}