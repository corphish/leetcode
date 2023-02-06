import java.util.Set;
import java.util.TreeSet;

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

        System.out.println("Orig " + range + " min=" + min + ", max=" + max);

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

        System.out.println("Adding " + range + " min=" + min + ", max=" + max);

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

        System.out.println("Corrected " + range + " min=" + min + ", max=" + max);

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
            System.out.println("Partial merge");
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

            System.out.println("First = " + first + ", last = " + last + ", set = " + toBeMerged);
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

        // return false;
    }

    void performSanity() {
        TreeSet<Range> copy = new TreeSet<>(set);
        set.clear();
        for (Range r: copy) {
            add(r);
        }
    }

    void show() {
        System.out.println(set);
    }
}
