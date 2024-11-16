// https://leetcode.com/problems/remove-sub-folders-from-the-filesystem
class Solution {
    public List<String> removeSubfolders(String[] folder) {
        Arrays.sort(folder, (a, b) -> a.compareTo(b));
        List<String> res = new ArrayList<>();
        String last = "";

        for (String path: folder) {
            if (last.isEmpty() || !path.startsWith(last) || (path.startsWith(last) && path.charAt(last.length()) != '/')) {
                last = path;
                res.add(path);
            }
        }

        return res;
    }
}