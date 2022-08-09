import java.util.function.BiFunction;
import java.lang.reflect.Array;

// https://leetcode.com/problems/range-sum-query-mutable
class NumArray {
    
    SegmentTree<Integer> tree;

    public NumArray(int[] nums) {
        tree = new SegmentTree(
            Arrays.stream(nums).boxed().toArray(),
            SegmentTree.SegmentTreeFunction.SUM_QUERY, 
            Integer.class
        );
    }
    
    public void update(int index, int val) {
        tree.update(index, val);
    }
    
    public int sumRange(int left, int right) {
        return tree.query(left, right);
    }
    
    /**
     * Class that implements segment tree.
     */
    class SegmentTree<T> {

        /**
         * Original array
         */
        private final T[] originalArray;

        // Size of the original array
        private final int n;

        // Segment tree
        // Formula: Index of left child = 2 * i + 1, index of right child = 2 * i + 2.
        private final T[] segmentTree;

        // Segment Operation
        private final SegmentTreeFunction<T> segmentTreeFunction;

        /**
         * Constructor.
         * 
         * @param arr Original array.
         * @param segmentOperation The operation on any 2 numbers that we want to compute and store it in our segment tree.
         */
        public SegmentTree(T[] arr, SegmentTreeFunction<T> segmentTreeFunction, Class<T> clazz) {
            this.originalArray = arr;
            this.n = arr.length;
            this.segmentTreeFunction = segmentTreeFunction;

            this.segmentTree = (T[]) Array.newInstance(clazz, 4 * n);

            // Build the segment tree
            build(0, 0, n - 1);
            // System.out.println("Segment tree = " + Arrays.toString(segmentTree));
        }

        /**
         * Builds the segment tree.
         * 
         * @param index Index of the segment tree whose value we are computing.
         * @param low Lower bound (inclusive) of the range of the original array whose value we are computing.
         * @param high Higher bound (inclusive) of the range of the original array whose value we are computing.
         */
        private void build(int index, int low, int high) {
            if (low == high) {
                segmentTree[index] = originalArray[low];
                return;
            }

            int mid = (low + high)/2;

            // Left
            build(2 * index + 1, low, mid);

            // Right
            build(2 * index + 2, mid + 1, high);

            segmentTree[index] = segmentTreeFunction.compute(segmentTree[2 * index + 1], segmentTree[2 * index + 2]);
        }

        /**
         * Queries the value for the given range [l, r];
         * 
         * @param l Lower bound of range (inclusive).
         * @param r Higher bound of range (inclusive).
         * @return Result of the query.
         */
        T query(int l, int r) {
            return _query(l, r, 0, n - 1, 0);
        }

        private T _query(int l, int r, int low, int high, int index) {
            // If the range that we are checking is completely within the range that is queried for.
            if (low >= l && high <= r) {
                return segmentTree[index];
            }

            // Does not lie at all
            if (low > r || high < l) {
                return segmentTreeFunction.fallbackValue;
            } else {
                /*if (low == high) {
                    return segmentTree[index];
                }*/

                // Overlaps
                int mid = (low + high)/2;
                return segmentTreeFunction.compute(_query(l, r, low, mid, 2 * index + 1), _query(l, r, mid + 1, high, 2 * index + 2)); 
            }
        }

        /**
         * Updates originalArra[pos] with the newVal.
         * 
         * @param pos Position of original array to update.
         * @param newVal New value to update the array with.
         * @return True if update was successful, false otherwise.
         */
        boolean update(int pos, T newVal) {
            if (pos < 0 || pos >= n) {
                return false;
            }

            _update(0, pos, 0, n - 1, newVal);
            // System.out.println("After update, segment tree = " + Arrays.toString(segmentTree));
            return true;
        }

        void _update(int index, int pos, int low, int high, T newVal) {
            if (low == pos && high == pos) {
                segmentTree[index] = newVal;
                return;
            }

            if (high < pos || low > pos) {
                // Out of range. Do nothing.
                return;
            }

            int mid = (low + high)/2;

            // Left
            _update(2 * index + 1, pos, low, mid, newVal);

            // Right
            _update(2 * index + 2, pos, mid + 1, high, newVal);

            segmentTree[index] = segmentTreeFunction.compute(segmentTree[2 * index + 1], segmentTree[2 * index + 2]);
        }

        /**
         * Function that we are trying to perform with a segment tree.
         */
        static class SegmentTreeFunction<T> {
            // Segment Operation
            private final BiFunction<T, T, T> segmentOperation;

            // Fallback value when a range query cannot be answered
            final T fallbackValue;

            /**
             * Constructor.
             * 
             * @param segmentOperation Function operation.
             * @param fallbackValue Fallback value.
             */
            public SegmentTreeFunction(BiFunction<T, T, T> segmentOperation, T fallbackValue) {
                this.fallbackValue = fallbackValue;
                this.segmentOperation = segmentOperation;
            }

            /**
             * Computes the function of the segment tree.
             * 
             * @param val1 1st operand.
             * @param val2 2nd operand.
             * @return Computed value.
             */
            T compute(T val1, T val2) {
                return segmentOperation.apply(val1, val2);
            }

            // Commonly used segment tree operations
            public static final SegmentTreeFunction<Integer> MAX_QUERY = new SegmentTreeFunction<Integer>((a, b) -> Math.max(a, b), Integer.MIN_VALUE);
            public static final SegmentTreeFunction<Integer> MIN_QUERY = new SegmentTreeFunction<Integer>((a, b) -> Math.min(a, b), Integer.MAX_VALUE);
            public static final SegmentTreeFunction<Integer> SUM_QUERY = new SegmentTreeFunction<Integer>((a, b) -> a + b, 0);
        }
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */