// https://leetcode.com/problems/meeting-rooms-iii
class Solution {
    public int mostBooked(int n, int[][] meetings) {
        Arrays.sort(meetings, (a, b) -> a[0] - b[0]);
        int[] counts = new int[n];
        TreeSet<Room> queue = new TreeSet<>();

        for (int i = 0; i < n; i++) {
            queue.add(new Room(i, 0));
        }

        for (int i = 0; i < meetings.length; i++) {
            TreeSet<Room> nowFree = new TreeSet<>((a, b) -> a.id - b.id);
            while (!queue.isEmpty() && queue.first().freeAt <= meetings[i][0]) {
                nowFree.add(queue.pollFirst());
            }

            Room r = nowFree.pollFirst();
            if (r!= null && r.freeAt <= meetings[i][0]) {
                r.setFreeTime(meetings[i][1]);
                queue.add(r);
                counts[r.id] += 1;
            } else {
                r = queue.pollFirst();
                int duration = meetings[i][1] - meetings[i][0];
                counts[r.id] += 1;
                r.setFreeTime(Math.max(r.freeAt, meetings[i][0]) + duration);
                queue.add(r);
            }

            for (Room x: nowFree) {
                queue.add(x);
            }
        }

        int max = 0, res = 0;
        for (int i = 0; i < n; i++) {
            if (counts[i] > max) {
                max = counts[i];
                res = i;
            }
        }

        return res;
    }

    class Room implements Comparable<Room> {
        final int id;
        long freeAt;

        Room(int id, int freeAt) {
            this.id = id;
            this.freeAt = freeAt;
        }

        void setFreeTime(long free) {
            this.freeAt = free;
        }

        public int compareTo(Room other) {
            int free = Long.compare(this.freeAt, other.freeAt);
            return free == 0 ? this.id - other.id : free;
        }
    }
}