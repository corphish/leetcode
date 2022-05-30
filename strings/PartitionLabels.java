class Solution {
    public List<Integer> partitionLabels(String s) {
        int[] lastIndexes = new int[128];
        Arrays.fill(lastIndexes, -1);
        List<Integer> res = new ArrayList<>();
        
        for (char c: s.toCharArray()) {
            if (lastIndexes[c] == -1) lastIndexes[c] = s.lastIndexOf("" + c);
        }
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int fitLength = lastIndexes[c];
            
            while (fitLength < s.length() - 1) {
                int newFitLength = fitLength(s, i, fitLength, lastIndexes);
                //System.out.printf("i = %d, c = %c, fitLength = %d, new = %d\n", i, c, fitLength, newFitLength);
                if (newFitLength <= fitLength) {
                    res.add(fitLength - i + 1);
                    i = fitLength;
                    break;
                }
                
                fitLength = newFitLength;
            }

            if (fitLength == s.length() - 1) {
                res.add(s.length() - i);
                break;
            }
        }
        
        return res;
    }
    
    int fitLength(String s, int start, int end, int[] lastIndexes) {
        char c = s.charAt(start);
        int lastIndex = lastIndexes[c];
        boolean b = true;
        for (int j = start + 1; j < end; j++) {
            char d = s.charAt(j);
            if (lastIndexes[d] > end) {
                return lastIndexes[d];
            }
        }
        
        return end;
    }
}