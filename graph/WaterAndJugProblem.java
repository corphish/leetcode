// https://leetcode.com/problems/water-and-jug-problem
class Solution {
    public boolean canMeasureWater(int x, int y, int target) {
        if (x + y < target) {
            return false;
        }

        boolean[] visited = new boolean[1001001];
        return check(x, y, 0, 0, target, visited);
    }

    int key(int c1, int c2) {
        return c1 * 1000 + c2;
    }

    boolean check(
        int x, int y,
        int c1, int c2, // states
        int target,
        boolean[] visited
    ) {
        //System.out.println(c1 + " " + c2);
        if (c1 == target || c2 == target || c1 + c2 == target) {
            return true;
        }

        if (visited[key(c1, c2)]) {
            return false;
        }

        visited[key(c1, c2)] = true;

        // 1: Fill c1
        boolean r1 = check(x, y, x, c2, target, visited);

        // 2: Fill c2
        boolean r2 = check(x, y, c1, y, target, visited);

        // 3: Empty c1
        boolean r3 = check(x, y, 0, c2, target, visited);

        // 4: Empty c2
        boolean r4 = check(x, y, c1, 0, target, visited);

        // 5: Pour c1 on c2
        int c2AfterPour = c1 + c2;
        int c2Excess = c2AfterPour - y;
        boolean r5 = check(x, y, c2Excess < 0 ? 0 : c2Excess, c2Excess < 0 ? c2AfterPour : y, target, visited);

        // 6: Pour c2 on c1
        int c1AfterPour = c1 + c2;
        int c1Excess = c1AfterPour - x;
        boolean r6 = check(x, y, c1Excess < 0 ? c1AfterPour : x, c1Excess < 0 ? 0 : c1Excess, target, visited);

        boolean res = r1 || r2 || r3 || r4 || r5 || r6;
        visited[key(c1, c2)] = false;

        return res;
    }
}