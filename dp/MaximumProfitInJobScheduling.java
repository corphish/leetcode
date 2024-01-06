// https://leetcode.com/problems/maximum-profit-in-job-scheduling
class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        List<Job> jobs = new ArrayList<>();
        Map<Integer, Integer> first = new HashMap<>();

        for (int i = 0; i < startTime.length; i++) {
            jobs.add(new Job(startTime[i], endTime[i], profit[i]));
        }

        Collections.sort(jobs);

        for (int i = 0; i < startTime.length; i++) {
            if (!first.containsKey(jobs.get(i).start)) {
                first.put(jobs.get(i).start, i);
            }
        }

        int[] dp = new int[jobs.size() + 1];

        for (int i = jobs.size(); i >= 0; i--) {
            if (i == jobs.size()) {
                dp[i] = 0;
                continue;
            }

            Job job = jobs.get(i);
            int max = 0;
            int ix = i;
            if (first.containsKey(job.end)) {
                ix = first.get(job.end);
            } else {
                ix = Collections.binarySearch(jobs, job.end());
                if (ix < 0) ix = -ix - 1;
            }
            
            for (int j = ix; j <= jobs.size(); j++) {
                max = Math.max(max, job.profit + dp[j]);
            }

            max = Math.max(max, dp[i + 1]);
            dp[i] = max;
        }

        return dp[0];
        //return max(jobs, first, 0);
    }

    int max(List<Job> jobs, Map<Integer, Integer> first, int i) {
        if (i >= jobs.size()) {
            return 0;
        }

        Job job = jobs.get(i);
        int max = 0;
        int ix = i;
        if (first.containsKey(job.end)) {
            ix = first.get(job.end);
        } else {
            ix = Collections.binarySearch(jobs, job.end());
            if (ix < 0) ix = -ix - 1;
        }
        
        for (int j = ix; j <= jobs.size(); j++) {
            max = Math.max(max, job.profit + max(jobs, first, j));
        }

        max = Math.max(max, max(jobs, first, i + 1));
        return max;
    }

    class Job implements Comparable<Job> {
        int start, end, profit;

        Job(int start, int end, int profit) {
            this.start = start;
            this.end = end;
            this.profit = profit;
        }

        public int compareTo(Job other) {
            return this.start - other.start;
        }

        public Job end() {
            return new Job(end, Integer.MAX_VALUE, profit);
        }

        public String toString() {
            return "{start="+start+", end="+end+", profit=" + profit+"}";
        }
    }
}