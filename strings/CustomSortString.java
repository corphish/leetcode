// https://leetcode.com/problems/custom-sort-string
class Solution {
    public String customSortString(String order, String s) {
        int[] arr = s.chars()
                    .boxed()
                    .sorted((a, b) -> {
                        int x = order.indexOf(((char) a.intValue()) + "");
                        int y = order.indexOf(((char) b.intValue()) + "");
                        
                        if (x < 0 && y < 0) return a - b;
                        if (x < 0) x = Integer.MAX_VALUE;
                        if (y < 0) y = Integer.MAX_VALUE;
                        
                        return x - y;
                    })
                    .mapToInt(x -> x)
                    .toArray();
        
        return new String(arr, 0, s.length());
    }
}