// https://leetcode.com/problems/data-stream-as-disjoint-intervals/
class SummaryRanges {

    private final Set<Integer> set;

    public SummaryRanges() {
        set = new TreeSet<>();
    }
    
    public void addNum(int value) {
        set.add(value);
    }
    
    public int[][] getIntervals() {
        int[][] res = new int[set.size()][2];

        int start = Integer.MIN_VALUE, last = start, i = 0;

        for (int x: set) {
            if (start == Integer.MIN_VALUE) {
                start = x;
                last = x;
                continue;
            } else {
                if (x - last > 1) {
                    res[i][0] = start;
                    res[i][1] = last;

                    start = x;
                    last = x;
                    i++;
                } else {
                    last = x;
                }
            }
        }

        res[i][0] = start;
        res[i][1] = last;
        i++;

        int[][] result = new int[i][2];
        for (int j = 0; j < result.length; j++) {
            result[j] = res[j];
        }

        return result;
    }


}

/**
 * Your SummaryRanges object will be instantiated and called as such:
 * SummaryRanges obj = new SummaryRanges();
 * obj.addNum(value);
 * int[][] param_2 = obj.getIntervals();
 */