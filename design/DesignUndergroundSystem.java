// https://leetcode.com/problems/design-underground-system
class UndergroundSystem {
    
    private Map<Integer, PendingJourney> pendingMap;
    private Map<String, RollingSum> completedMap;

    public UndergroundSystem() {
        pendingMap = new HashMap<>();
        completedMap = new HashMap<>();
    }
    
    public void checkIn(int id, String stationName, int t) {
        pendingMap.put(id, new PendingJourney(stationName, t));
    }
    
    public void checkOut(int id, String stationName, int t) {
        PendingJourney pj = pendingMap.get(id);
        pj.completeJourney(stationName, t).updateMap(completedMap);
    }
    
    public double getAverageTime(String startStation, String endStation) {
        return completedMap.get(startStation + ", " + endStation).average();
    }
    
    class PendingJourney {
        String src;
        int start;
        
        PendingJourney(String src, int start) {
            this.src = src;
            this.start = start;
        }
        
        CompletedJourney completeJourney(String dest, int end) {
            int time = end - start;
            return new CompletedJourney(src, dest, time);
        }
    }
    
    class CompletedJourney {
        String src, dest;
        int time;
        
        CompletedJourney(String src, String dest, int time) {
            this.src = src;
            this.dest = dest;
            this.time = time;
        }
        
        void updateMap(Map<String, RollingSum> map) {
            String key = src + ", " + dest;
            RollingSum rs = map.getOrDefault(key, new RollingSum());
            rs.add(time);
            map.put(key, rs);
        }
    }
    
    class RollingSum {
        int sum = 0, count = 0;
        
        void add(int x) {
            sum += x;
            count++;
        }
        
        double average() {
            return (sum * 1.0)/count;
        }
    }
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */