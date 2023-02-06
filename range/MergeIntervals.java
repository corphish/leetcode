// https://leetcode.com/problems/merge-intervals/
class Solution {
    public int[][] merge(int[][] intervals) {
        RangeModule rm = new RangeModule();
        List<Range> ranges = new ArrayList<>();

        for (int[] range: intervals) {
            ranges.add(new Range(range));
        }

        Collections.sort(ranges);
        for (Range range: ranges) {
            rm.add(range);
        }

        return rm.intervals();
    }

    class Range implements Comparable<Range> {
        // Inclusive points
        final int from, to;

        Range(int from, int to) {
            this.from = from;
            this.to = to;
        }

        Range(int[] range) {
            this(range[0], range[1]);
        }

        public Range fromOnly() {
            return new Range(from, from);
        }

        public Range toOnly() {
            return new Range(to, to);
        }

        public int[] toArray() {
            return new int[] {from, to};
        }

        boolean isNotOverlapping(Range other) {
            return this.from > other.to || this.to < other.from;
        }

        boolean completelyOverlaps(Range other) {
            return other.from >= this.from && other.from <= this.to && other.to <= this.to && other.to >= this.from;
        }

        public String toString() {
            return "Range(from=" + from + ", to=" + to + ")";
        }

        public boolean equals(Object other) {
            if (!(other instanceof Range)) {
                return false;
            }

            Range r = (Range) other;
            return this.from == r.from && this.to == r.to;
        }

        @Override
        public int compareTo(Range other) {
            return this.from == other.from ? this.to - other.to : this.from - other.from;
        } 
    }

    public class RangeModule {
        private final TreeSet<Range> set = new TreeSet<>();

        /**
        * Adds a range to the ordered set of tracked ranges.
        * 
        * @param range Range to add.
        * @return True if range was added, false otherwise.
        */
        boolean add(Range range) {
            Range fromOnly = range.fromOnly();
            Range toOnly = range.toOnly();

            Range min = set.floor(fromOnly);
            Range max = set.ceiling(toOnly);

            if (min == null || max == null) {
                min = set.floor(range);
                max = set.ceiling(range);
            }

            if (min == null && max == null) {
                if (set.size() == 0) {
                    set.add(range);
                    return true;
                }
            }

            if (min != null && max != null && min.equals(max)) {
                if (range.from < min.from) {
                    max = null;
                } else if (range.to > max.to) {
                    min = null;
                }
            }

            // If the element we are trying to add is less than least range entry
            if (min != null && max == null) {
                if (min.isNotOverlapping(range)) {
                    set.add(range);
                    return true;
                } else {
                    if (min.completelyOverlaps(range)) {
                        return false;
                    }
                    
                    // Merge the two
                    Range merge = new Range(Math.min(min.from, range.from), Math.max(min.to, range.to));
                    set.remove(min);
                    set.add(merge);
                    return true;
                }
            }

            // If the element we are trying to add is greater than greatest range entry
            if (min == null && max != null) {
                if (max.isNotOverlapping(range)) {
                    set.add(range);
                    return true;
                } else {
                    if (max.completelyOverlaps(range)) {
                        return false;
                    }

                    // Merge the two
                    Range merge = new Range(Math.min(max.from, range.from), Math.max(max.to, range.to));
                    set.remove(max);
                    set.add(merge);
                    return true;
                }
            }

            if (min.compareTo(max) > 0) {
                Range temp = min;
                min = max;
                max = temp;
            }

            if (min.isNotOverlapping(range) && max.isNotOverlapping(range)) {
                set.add(range);
                return true;
            }

            Set<Range> subset = set.subSet(min,  true, max, true);

            if (!min.isNotOverlapping(range) && !max.isNotOverlapping(range)) {
                Range merge = new Range(Math.min(min.from, range.from), Math.max(max.to, range.to));
                set.removeAll(new TreeSet<>(subset));
                set.add(merge);
                return true;
            } else {
                Range first = null, last = null;
                Set<Range> toBeMerged = new TreeSet<>();
                for (Range r: subset) {
                    if (r.isNotOverlapping(range)) {
                        if (first == null) {
                            continue;
                        } else {
                            break;
                        }
                    } else {
                        if (first == null) {
                            first = r;
                        } else {
                            last = r;
                        }

                        toBeMerged.add(r);
                    }
                }

                if (last == null) {
                    Range merge = new Range(Math.min(first.from, range.from), Math.max(first.to, range.to));
                    set.removeAll(toBeMerged);
                    set.add(merge);
                    return true;
                } else {
                    Range merge = new Range(Math.min(first.from, range.from), Math.max(last.to, range.to));
                    set.removeAll(toBeMerged);
                    set.add(merge);
                    return true;
                }
            }
        }

        int[][] intervals() {
            int[][] res = new int[set.size()][2];
            int i = 0;

            for (Range r: set) {
                res[i++] = r.toArray();
            }

            return res;
        }

        void performSanity() {
            TreeSet<Range> copy = new TreeSet<>(set);
            set.clear();
            for (Range r: copy) {
                add(r);
            }
        }
    }
}