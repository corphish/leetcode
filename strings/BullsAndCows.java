// https://leetcode.com/problems/bulls-and-cows
class Solution {
    public String getHint(String secret, String guess) {
        Map<Integer, Set<Integer>> indexMap = new HashMap<>();
        Set<Integer> bullIndexes = new HashSet<>();
        int bulls = 0, cows = 0;
        
        for (int i = 0; i < secret.length(); i++) {
            int num = secret.charAt(i) - '0';
            indexMap.computeIfAbsent(num, x -> new HashSet<>()).add(i);
        }
        
        for (int i = 0; i < guess.length(); i++) {
            Set<Integer> index = indexMap.get(guess.charAt(i) - '0');
            if (index != null && !index.isEmpty()) {
                if (index.contains(i)) {
                    bulls++;
                    bullIndexes.add(i);
                    index.remove(i);
                }
            } 
        }
        
        for (int i = 0; i < guess.length(); i++) {
            if (bullIndexes.contains(i)) continue;
            Set<Integer> index = indexMap.get(guess.charAt(i) - '0');
            if (index != null && !index.isEmpty()) {
                cows++;
                var it = index.iterator();
                index.remove(it.next());
            } 
        }
        
        return bulls + "A" + cows + "B";
    }
}