// https://leetcode.com/problems/group-the-people-given-the-group-size-they-belong-to
class Solution {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        Map<Integer, List<List<Integer>>> group = new HashMap<>();
        for (int i = 0; i < groupSizes.length; i++) {
            int size = groupSizes[i];
            var data = group.getOrDefault(size, new ArrayList<>());
            var last = data.isEmpty() ? null : data.get(data.size() - 1);
            if (last == null) {
                last = new ArrayList<>();
                last.add(i);
                data.add(last);
            } else {
                if (last.size() < size) {
                    last.add(i);
                } else {
                    List<Integer> newList = new ArrayList<Integer>();
                    newList.add(i);
                    data.add(newList);
                }
            }
            
            group.put(size, data);
        }
        
        List<List<Integer>> res = new ArrayList<>();
        for (var l: group.values()) {
            for (var e: l) res.add(e);
        }
        
        return res;
    }
}