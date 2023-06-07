// https://leetcode.com/problems/frequency-tracker
class FrequencyTracker {

    int[] map = new int[100001];
    int[] rev = new int[200001];

    public FrequencyTracker() {
        
    }
    
    public void add(int number) {
        int prevFreq = map[number];
        
        map[number] += 1;

        if (prevFreq != 0) {
            rev[prevFreq] -= 1;
        }

        rev[map[number]] += 1;
    }
    
    public void deleteOne(int number) {
        int prevFreq = map[number];

        if (prevFreq != 0) {
            map[number] -= 1;
            rev[prevFreq] -= 1;
        }

        if (map[number] != 0)
            rev[map[number]] += 1;
    }
    
    public boolean hasFrequency(int frequency) {
        return rev[frequency] > 0;
    }
}

/**
 * Your FrequencyTracker object will be instantiated and called as such:
 * FrequencyTracker obj = new FrequencyTracker();
 * obj.add(number);
 * obj.deleteOne(number);
 * boolean param_3 = obj.hasFrequency(frequency);
 */