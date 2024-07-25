// https://leetcode.com/problems/minimum-cost-to-set-cooking-time/
class Solution {
    public int minCostSetTime(int startAt, int moveCost, int pushCost, int targetSeconds) {
        int min = Integer.MAX_VALUE;
        for (int t: possible(targetSeconds)) {
            min = Math.min(min, cost(t, startAt, moveCost, pushCost));
        }

        return min;
    }

    int[] possible(int seconds) {
        int ss = seconds % 60;
        if (ss < 40) {
            return new int[] {
                (seconds/60) * 100 + ss,
                (seconds/60 - 1) * 100 + (60 + ss),
            };
        } else {
            return new int[] {
                (seconds/60) * 100 + ss,
            };
        }
    }

    int cost(int time, int start, int move, int push) {
        if (time < 0) {
            return Integer.MAX_VALUE;
        }

        int rev = 0, res = 0, count = 0, tr = 0;
        boolean flag = false;
        while (time > 0) {
            if (time % 10 == 0 && !flag) {
                tr += 1;
            } else {
                flag = true;
            }

            rev = rev * 10 + (time % 10);
            time /= 10;
            count += 1;
        }

        if (count > 4) {
            return Integer.MAX_VALUE;
        }

        time = rev;

        while (time > 0) {
            int d = time % 10;
            if (d != start) {
                res += move;
            }

            res += push;
            start = d;
            time /= 10;
            count -= 1;
        }

        if (tr > 0) {
            if (start != 0) {
                res += move;
            }

            res += tr * push;
            start = 0;
        }

        return res;
    }
}