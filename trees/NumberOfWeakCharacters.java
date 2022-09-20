// https://leetcode.com/problems/the-number-of-weak-characters-in-the-game
class Solution {
    public int numberOfWeakCharacters(int[][] properties) {
        List<Property> list = new ArrayList<>();
        
        for (int[] property: properties) {
            list.add(new Property(property));
        }
        
        // Collect the property in a model and sort them in decreasing order of their attack value.
        Collections.sort(list, Collections.reverseOrder());
        
        int count = 0;
        
        // A custom AVL should give better runtime ms but overall the time complexity will remain same if we use TreeMap
        TreeMap<Integer, Property> map = new TreeMap<>();
        
        // For each prop in sorted list, check if there is any previously visited prop with attack and defence values
        // greater than this prop.
        // Since the list is already sorted by attack values, the attack values of previously visited props will be
        // greater or equal to this prop. So we just have to check starting with the prop which has defence value higher than the prop we are checking, and if it has higher def but same attack we keep on checking.
        for (Property prop: list) {            
            if (check(map, prop)) {
                count++;
            }
            
            // Only put key once
            if (!map.containsKey(prop.defence)) {
                map.put(prop.defence, prop);
            }
        }
        
        return count;
    }
    
    // Returns true if there exists a property whose attack and defence value are greater than
    // passed prop in tree
    boolean check(TreeMap<Integer, Property> map, Property property) {
        if (map.isEmpty()) {
            return false;
        }
        
        Integer nextHighest = map.higherKey(property.defence);
        while (nextHighest != null) {
            Property high = map.get(nextHighest);
            if (high.attack > property.attack && high.defence > property.defence) {
                return true;
            }
            
            nextHighest = map.higherKey(high.defence);
        }
        
        return false;
    }
    
    class Property implements Comparable<Property> {
        int attack, defence;
        
        Property(int[] property) {
            this.attack = property[0];
            this.defence = property[1];
        }
        
        public int compareTo(Property other) {
            return this.attack == other.attack ? this.defence - other.defence : this.attack - other.attack;
        }
        
        public String toString() {
            return "(" + attack + ", " + defence + ")";
        }
    }
}