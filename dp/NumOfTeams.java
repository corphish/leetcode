// https://leetcode.com/problems/count-number-of-teams
class Solution {
    // Build 2 maps: 1 where key is the index, and value is a list of all indexes where value is less than element at key index
    //               1 where key is the index, and value is a list of all indexes where value is greater than element at key index
    // Now pick an index, for every index, get the list of indexes from one of the map, sum each of the list element. Do the same for the other map.
    public int numTeams(int[] rating) {
        Map<Integer, List<Integer>> lessMap = new HashMap<>();
        Map<Integer, List<Integer>> greaterMap = new HashMap<>();
        
        int count = 0;
        
        for (int i = 0; i < rating.length; i++) {
            List<Integer> listLess = new ArrayList<>();
            List<Integer> listGreater = new ArrayList<>();
            for (int j = i + 1; j < rating.length; j++) {
                if (rating[j] < rating[i]) {
                    listLess.add(j);
                } else if (rating[j] > rating[i]) {
                    listGreater.add(j);
                }
            }
            
            lessMap.put(i, listLess);
            greaterMap.put(i, listGreater);
        }
        
        for (List<Integer> list: lessMap.values()) {
            for (int x: list) {
                count += lessMap.get(x).size();
            }
        }
        
        for (List<Integer> list: greaterMap.values()) {
            for (int x: list) {
                count += greaterMap.get(x).size();
            }
        }
        
        return count;
    }
}