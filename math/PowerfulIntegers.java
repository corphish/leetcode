// https://leetcode.com/problems/powerful-integers
class Solution {
    public List<Integer> powerfulIntegers(int x, int y, int bound) {
        Set<Integer> set = new HashSet<>();

        if (bound == 0) {
            return new ArrayList<>();
        }

        int bx = x == 1 ? 0 : (int) (Math.log(bound)/Math.log(x));
        int by = y == 1 ? 0 : (int) (Math.log(bound)/Math.log(y));

        for (int i = 0; i <= bx; i++) {
            for (int j = 0; j <= by; j++) {
                int z = (int) (Math.pow(x, i) + Math.pow(y, j));
                if (z <= bound) {
                    set.add(z);
                }
            }
        }

        return set.stream().collect(Collectors.toList());
    }
}