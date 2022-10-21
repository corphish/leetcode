// https://leetcode.com/problems/time-based-key-value-store/
class TimeMap {
    
    Map<String, List<Data>> map = new HashMap<>();

    public TimeMap() {
        
    }
    
    public void set(String key, String value, int timestamp) {
        map.computeIfAbsent(key, x -> new ArrayList<>()).add(new Data(value, timestamp));
    }
    
    public String get(String key, int timestamp) {
        List<Data> list = map.get(key);
        if (list == null) {
            return "";
        }
        Data dummy = new Data("", timestamp);
        int ix = Collections.binarySearch(list, dummy);
        
        if (ix >= 0) {
            return list.get(ix).value;
        } else {
            ix = -ix - 1;
            if (ix == 0) {
                return "";
            } else {
                return list.get(ix - 1).value;
            }
        }
    }
    
    class Data implements Comparable<Data> {
        String value;
        int ts;
        
        Data(String value, int ts) {
            this.value = value;
            this.ts = ts;
        }
        
        public int compareTo(Data other) {
            return this.ts - other.ts;
        }
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */