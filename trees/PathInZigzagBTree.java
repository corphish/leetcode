// https://leetcode.com/problems/path-in-zigzag-labelled-binary-tree/
class Solution {
    public List<Integer> pathInZigZagTree(int label) {
        List<Integer> res = new ArrayList<>();
        int parent = label;
        
        while (parent > 0) {
            res.add(parent);
            
            // Power of 2 of minimum value of current level where
            // parent is present
            int currLevel = binlog(parent);// (int) (Math.log(parent)/Math.log(2));
            
            // Min and max values in prev level
            int minInPrev = 1 << (currLevel - 1);
            int maxInPrev = (1 << currLevel) - 1;
            
            // Expected parent of current node
            int exp = parent/2;
            
            // Adjust: We check how far the exp is from maxInPrev
            // then we add the diff to minInPrev to get its parent
            parent = minInPrev + (maxInPrev - exp);
        }
        
        Collections.reverse(res);
        return res;
    }
    
    // https://stackoverflow.com/questions/3305059/how-do-you-calculate-log-base-2-in-java-for-integers
    public static int binlog(int bits) {
        int log = 0;
        if( ( bits & 0xffff0000 ) != 0 ) { bits >>>= 16; log = 16; }
        if( bits >= 256 ) { bits >>>= 8; log += 8; }
        if( bits >= 16  ) { bits >>>= 4; log += 4; }
        if( bits >= 4   ) { bits >>>= 2; log += 2; }
        return log + ( bits >>> 1 );
    }
}