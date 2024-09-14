// https://leetcode.com/problems/walking-robot-simulation
class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        int[] pos = new int[2];
        int[] temp = pos.clone();
        int dir = 0; // 0 - North, 1 - East, 2 - South, 3 - West
        int max = 0;

        Set<Integer> set = new HashSet<>();
        for (int[] o: obstacles) {
            set.add(hash(o));
        }

        for (int c: commands) {
            if (c < 0) {
                if (c == -1) {
                    dir += 1;
                } else {
                    dir -= 1;
                }

                if (dir < 0) {
                    dir = 3;
                } else if (dir > 3) {
                    dir = 0;
                }
            } else {
                for (int i = 1; i <= c; i++) {
                    if (dir == 0) {
                        temp[1] += 1;
                    } else if (dir == 1) {
                        temp[0] += 1;
                    } else if (dir == 2) {
                        temp[1] -= 1;
                    } else {
                        temp[0] -= 1;
                    }

                    if (!set.contains(hash(temp))) {
                        pos[0] = temp[0];
                        pos[1] = temp[1];
                    } else {
                        temp[0] = pos[0];
                        temp[1] = pos[1];
                        break;
                    }

                    max = Math.max(max, pos[0] * pos[0] + pos[1] * pos[1]);
                }
            }
        }

        return max;
    }

    int hash(int[] arr) {
        return arr[0] * 100000 + arr[1];
    }
}