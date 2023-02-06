// https://leetcode.com/problems/gas-station/
class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int min = 0, minIndex = 0, tank = 0;
        for (int i = 0; i < gas.length; i++) {
            tank += gas[i];
            tank -= cost[i];

            if (tank < min) {
                min = tank;
                minIndex = i + 1;
            }
        }

        tank = 0;
        int start = minIndex % gas.length;
        for (int i = start; ;) {
            tank += gas[i];
            tank -= cost[i];

            if (tank < 0) {
                return -1;
            }

            if ((start == 0 && i == gas.length - 1) || (i == start - 1)) {
                break;
            }

            i++;
            i = i % gas.length;
        }

        return minIndex;
    }
}