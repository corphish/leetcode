class Solution {
    
    int n, start, val;
    Map<Integer, Integer> reroute;

    // Idea is to build a map which will have the blacklist values as keys
    // and will tell you what is the next valid value that you can return.
    public Solution(int n, int[] blacklist) {
        reroute = new HashMap<>();
        this.n = n;
        
        if (blacklist.length > 0) {
            Arrays.sort(blacklist);

            // Determine the start
            if (blacklist[0] != 0) {
                start = 0;
            } else {
                boolean startFound = false;
                for (int i = 1; i < blacklist.length; i++) {
                    if (blacklist[i] - blacklist[i - 1] > 1) {
                        start = blacklist[i - 1] + 1;
                        startFound = true;
                        break;
                    }
                }
                
                if (!startFound) {
                    start = blacklist[blacklist.length - 1] + 1;
                }
            }
            
            // When we reach n, we have to shift our pointer to start instead of 0.
            int ix = Arrays.binarySearch(blacklist, start);
            ix = -ix - 1;
            //System.out.println("index = " + ix);
            List<Integer> temp = new ArrayList<>();
            for (int i = ix; i < blacklist.length - 1; i++) {
                if (blacklist[i + 1] - blacklist[i] > 1) {
                    reroute.put(blacklist[i], blacklist[i] + 1);
                    for (int x: temp) {
                        reroute.put(x, blacklist[i] + 1);
                    }
                    
                    temp.clear();
                } else {
                    temp.add(blacklist[i]);
                }
            }
            
            // If temp is not empty, we have to map proper values
            // value = start if blacklist[blacklist.length - 1] == n - 1 else blacklist[blacklist.length - 1] + 1
            for (int x: temp) {
                if (blacklist[blacklist.length - 1] == n - 1) {
                    reroute.put(x, start);
                } else {
                    reroute.put(x, blacklist[blacklist.length - 1] + 1);
                }
            }
            
            // We have to do something for the last element
            if (blacklist[blacklist.length - 1] == n - 1) {
                reroute.put(blacklist[blacklist.length - 1], start);
            } else {
                reroute.put(blacklist[blacklist.length - 1], blacklist[blacklist.length - 1] + 1);
            }
            
            // At this point if map is empty, blacklist is all but start
            for (int x: blacklist) {
                if (x > start && !reroute.containsKey(x))
                    reroute.put(x, start);
            }
            
            //System.out.println("start = " + start + ", reroute = " + reroute);
            
            this.val = start;
        }
    }
    
    public int pick() {
        if (val >= n) {
            val = start;
            return val++;
        }
        
        if (reroute.containsKey(val)) {
            val = reroute.get(val);
        }
        
        return val++;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(n, blacklist);
 * int param_1 = obj.pick();
 */