// https://leetcode.com/problems/earliest-possible-day-of-full-bloom
class Solution {
    // Example 2
    // 0 - Plant on 0, grows from 1, blooms on 3
    // 1 - Plant on 4, grows from 6, blooms on 7
    // 2 - Plant on 1, grows from 4, blooms on 6
    // 3 - Plant on 6, grows from 5, blooms on 6
    public int earliestFullBloom(int[] plantTime, int[] growTime) {
        int day = 0;
        int maxBloom = 0;

        List<Flower> flowers = new ArrayList<>();
        for (int i = 0; i < plantTime.length; i++) {
            flowers.add(new Flower(plantTime[i], growTime[i]));
        }

        Collections.sort(flowers);
        // System.out.println(flowers);

        for (Flower f: flowers) {
            int[] res = f.startWorking(day);
            day = res[0];
            maxBloom = Math.max(maxBloom, res[1]);
        }

        return maxBloom;
    }

    class Flower implements Comparable<Flower> {
        int plantTime, growTime;

        Flower(int plantTime, int growTime) {
            this.plantTime = plantTime;
            this.growTime = growTime;
        }

        int[] startWorking(int startDay) {
            return new int[] {
                // Indicates when the person will be free
                startDay + plantTime,

                // Indicates when this flower will bloom
                startDay + plantTime + growTime,
            };
        }

        public int compareTo(Flower other) {
            // Prefer the ones that takes long time to bloom
            // In case of tie, prefer the ones that take short time to plant
            return this.growTime == other.growTime ? this.plantTime - other.plantTime : other.growTime - this.growTime;
        }

        public String toString() {
            return String.format("{plantTime=%d, growTime=%d}\n", plantTime, growTime);
        }
    }
}