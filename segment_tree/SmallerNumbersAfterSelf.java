// https://leetcode.com/problems/count-of-smaller-numbers-after-self
class Solution {
    int SIZE;
    int OFFSET;
    
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> res = new ArrayList<>();
        
        computeVariables(nums);
        
        SegmentTree segmentTree = new SegmentTree(SIZE);
        
        for (int i = nums.length - 1; i >= 0; i--) {
            int index = nums[i] + OFFSET;
            segmentTree.increment(index);
            res.add(segmentTree.query(0, index - 1));
        }
        
        Collections.reverse(res);        
        return res;
    }
    
    void computeVariables(int[] nums) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        
        for (int x: nums) {
            max = Math.max(x, max);
            min = Math.min(x, min);
        }
        
        int diff = max - min;
        SIZE = 2 * diff + 1;
        OFFSET = -min;
    }
    
    /**
     * Class that implements segment tree.
     */
    class SegmentTree {

        // Segment tree
        // Formula: Index of left child = 2 * i + 1, index of right child = 2 * i + 2.
        private final int[] segmentTree;
        
        // Size of array.
        private final int n;

        /**
         * Constructor.
         * 
         * @param n Size of array.
         */
        public SegmentTree(int n) {
            this.n = n;
            this.segmentTree = new int[4 * n];
        }

        /**
         * Queries the value for the given range [l, r];
         * 
         * @param l Lower bound of range (inclusive).
         * @param r Higher bound of range (inclusive).
         * @return Result of the query.
         */
        int query(int l, int r) {
            return _query(l, r, 0, n - 1, 0);
        }

        private int _query(int l, int r, int low, int high, int index) {
            // If the range that we are checking is completely within the range that is queried for.
            if (low >= l && high <= r) {
                return segmentTree[index];
            }

            // Does not lie at all
            if (low > r || high < l) {
                return 0;
            } else {
                /*if (low == high) {
                    return segmentTree[index];
                }*/

                // Overlaps
                int mid = (low + high)/2;
                return _query(l, r, low, mid, 2 * index + 1) + _query(l, r, mid + 1, high, 2 * index + 2); 
            }
        }

        /**
         * Updates originalArra[pos] with the newVal.
         * 
         * @param pos Position of original array to update.
         * @param newVal New value to update the array with.
         * @return True if update was successful, false otherwise.
         */
        boolean increment(int pos) {
            if (pos < 0 || pos >= n) {
                return false;
            }

            _increment(0, pos, 0, n - 1);
            // System.out.println("After update, segment tree = " + Arrays.toString(segmentTree));
            return true;
        }

        void _increment(int index, int pos, int low, int high) {
            if (low == pos && high == pos) {
                segmentTree[index] += 1;
                return;
            }

            if (high < pos || low > pos) {
                // Out of range. Do nothing.
                return;
            }

            int mid = (low + high)/2;

            // Left
            _increment(2 * index + 1, pos, low, mid);

            // Right
            _increment(2 * index + 2, pos, mid + 1, high);

            segmentTree[index] = segmentTree[2 * index + 1] + segmentTree[2 * index + 2];
        }
    }
}