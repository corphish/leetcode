// https://leetcode.com/problems/find-duplicate-file-in-system
class Solution {
    public List<List<String>> findDuplicate(String[] paths) {
        List<List<String>> res = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        
        for (String path: paths) {
            String[] parts = path.split(" ");
            String dir = parts[0];
            
            for (int i = 1; i < parts.length; i++) {
                int firstIndex = parts[i].indexOf("(");
                String fileName = parts[i].substring(0, firstIndex);
                String contents = parts[i].substring(firstIndex);
                
                map.computeIfAbsent(contents, x -> new ArrayList<>()).add(dir + "/" + fileName);
            }
        }
        
        for (var e: map.entrySet()) {
            if (e.getValue().size() > 1) {
                res.add(e.getValue());
            }
        }
        
        return res;
    }
}