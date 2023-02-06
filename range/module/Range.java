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