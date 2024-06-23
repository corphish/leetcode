// https://leetcode.com/problems/most-profit-assigning-work
class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int maxDiff = 0;
        for (int x: difficulty) {
            maxDiff = Math.max(maxDiff, x);
        }

        for (int x: worker) {
            maxDiff = Math.max(maxDiff, x);
        }

        List<Job> jobs = new ArrayList<>();
        for (int i = 0; i < profit.length; i++) {
            jobs.add(new Job(profit[i], difficulty[i]));
        } 

        Collections.sort(jobs, (a, b) -> a.d - b.d);

        int[] map = new int[maxDiff + 1];
        int lastDiff = 0;
        for (Job j: jobs) {
            map[j.d] = Math.max(map[j.d], Math.max(j.p, lastDiff));
            lastDiff = map[j.d];
        }

        int last = 0;
        for (int i = 0; i < map.length; i++) {
            if (map[i] == 0) {
                map[i] = -last;
            } else {
                last = i;
            }
        }

        int total = 0, i = 0;
        for (int w: worker) {
            int p = map[w];
            if (p < 0) {
                p = map[-p];
            }

            total += p;
            i += 1;
        }

        return total;
    }

    class Job {
        int p, d;

        Job(int p, int d) {
            this.p = p;
            this.d = d;
        }
    }
}