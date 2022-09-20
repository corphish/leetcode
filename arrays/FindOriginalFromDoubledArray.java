// https://leetcode.com/problems/find-original-array-from-doubled-array
class Solution {
    public int[] findOriginalArray(int[] changed) {
        Arrays.sort(changed);
        Map<Integer, List<Integer>> map = new TreeMap<>();
        Map<Integer, Integer> freq = new HashMap<>();
        
        if (changed.length % 2 == 1) {
            return new int[] {};
        }
        
        for (int i = 0; i < changed.length; i++) {
            if (changed[i] % 2 == 0) {
                if (map.containsKey(changed[i]/2)) {
                    List<Integer> l = map.get(changed[i]/2);
                    l.add(changed[i]);
                    map.put(changed[i]/2, l);
                }
            }
            
            if (!map.containsKey(changed[i])) {
                map.put(changed[i], new ArrayList<>());
            }
            
            freq.put(changed[i], freq.getOrDefault(changed[i], 0) + 1);
        }
        
        // System.out.println(map);
        
        int res[] = new int[changed.length/2], k = 0;
        for (var e: map.entrySet()) {
            // System.out.println("Freq=" + freq);
            int keyFreq= freq.get(e.getKey());
            int doubleCount = freq.getOrDefault(e.getKey() * 2, 0);
            
            if (keyFreq == 0) continue;
            
            // Handle zero separately
            if (e.getKey() == 0) {
                if (keyFreq % 2 == 1) {
                    //System.out.println("1");
                    return new int[] {};
                }
            
                for (int i = 0; i < keyFreq/2; i++) {
                    res[k++] = 0;
                }
                
                freq.put(0, 0);
                continue;
            }
            
            if (doubleCount < keyFreq) {
                //System.out.println("2");
                continue;
            }
            
            for (int i = 0; i < keyFreq; i++) {
                if (k >= changed.length/2) {
                    //System.out.println("3");
                    return new int[] {};
                }
                
                res[k++] = e.getKey();
                freq.put(e.getKey(), freq.get(e.getKey()) - 1);
                freq.put(e.getKey() * 2, freq.get(e.getKey() * 2) - 1);
            }
        }
        
        if (k < changed.length/2) {
            //System.out.println("4, k =" + k);
            return new int[] {};
        }

        return res;
    }
}