// https://leetcode.com/problems/range-frequency-queries/
class RangeFreqQuery {
    
    Map<Integer, List<Integer>> indices;

    public RangeFreqQuery(int[] arr) {
        indices = new HashMap<>();
        
        for (int i = 0; i < arr.length; i++) {
            List<Integer> l = indices.getOrDefault(arr[i], new ArrayList<>());
            l.add(i);
            indices.put(arr[i], l);
        }
    }
    
    public int query(int left, int right, int value) {
        List<Integer> l = indices.get(value);
        
        if (l == null) {
            return 0;
        }
        
        //System.out.println(l);
        
        int lix = Collections.binarySearch(l, left);
        int rix = Collections.binarySearch(l, right);
        
        //System.out.println(lix + " " + rix);
        
        // Rules of binary search counting from l and r
        // 1. If both l and r exists in array, count = rix - lix + 1
        // 2. If only r exists (l doesnt), count = rix - (adjusted lix) + 1
        // 3. If only l exists (r doesnt), count = (adjusted rix) - lix
        // 3. If none exists, count = adjusted(rix) - adjusted(lix)
        if (lix >= 0 && rix >= 0) {
            return rix - lix + 1;
        } else if (lix >= 0) {
            // left = 0, right = 3
            // [0, 1, 4]
            // lix = 0, rix = 2
            rix = -rix - 1;
            
            return rix - lix;
        } else if (rix >= 0) {
            // left = 0, right = 3
            // [1, 3, 4]
            // lix = 0, rix = 1
            lix = -lix - 1;
            
            return rix - lix + 1;
        } else {
            // left = 0, right = 4
            // [1, 3, 5]
            // lix = 0, rix = 2
            lix = -lix - 1;
            rix = -rix - 1;
            
            return rix - lix;
        }
    }
}

/**
 * Your RangeFreqQuery object will be instantiated and called as such:
 * RangeFreqQuery obj = new RangeFreqQuery(arr);
 * int param_1 = obj.query(left,right,value);
 */