public class MinCostToMoveChips {
    public int minCostToMoveChips(int[] position) {
        Set<Integer> pos = new TreeSet<>();
        
        Map<Integer, Integer> freq = new HashMap<>();
        
        for (int x: position) {
            pos.add(x);
            freq.put(x, freq.getOrDefault(x, 0) + 1);
        }
        
        int min = Integer.MAX_VALUE;
        
        for (int x: pos) {
            //System.out.println("Will be moved to " + x);
            int cost = 0;
            for (int y: pos) {
                if (x != y) {
                    cost += freq.get(y) * (Math.abs(x - y) % 2);
                }
            }
            //System.out.println(cost);
            min = Math.min(min, cost);
        }
        
        return min;
    }
}
