// https://leetcode.com/problems/task-scheduler
class Solution {
    // Create a task class to hold the task name, count and last executed.
    // Priority depends on the count of the task.
    // Do this while there are any pending tasks (queue is not empty).
    // 1. Get the task with highest priority.
    // 2. If the task can be executed, execute it (reduce count, update timestamp)
    // and update in the queue.
    // 3. If the task cannot be executed, get the next task in queue that can be
    // executed, execute it and update in queue.
    // 4. Make sure to keep track of the tasks we are checking in step 3, and add
    // them back in queue after a task was executed (this needs
    // to be done because we are polling).
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[32];
        PriorityQueue<Task> queue = new PriorityQueue<>();

        for (char t : tasks) {
            freq[t - 'A']++;
        }

        for (int i = 0; i < 32; i++) {
            if (freq[i] > 0) {
                queue.add(new Task(i + 65, freq[i]));
            }
        }

        int time = 0;
        for (; !queue.isEmpty(); time++) {
            Task t = queue.poll();
            if (t.canBeExecuted(time, n)) {
                int newCount = t.execute(time);
                if (newCount > 0)
                    queue.add(t);
            } else {
                Stack<Task> polled = new Stack<>();
                polled.push(t);
                while (!queue.isEmpty()) {
                    Task other = queue.poll();
                    if (other.canBeExecuted(time, n)) {
                        int newCount = other.execute(time);
                        if (newCount > 0)
                            queue.add(other);
                        break;
                    } else {
                        polled.push(other);
                    }
                }

                while (!polled.isEmpty()) {
                    queue.add(polled.pop());
                }
            }
        }

        return time;
    }

    class Task implements Comparable<Task> {
        char name;
        int count, lastExecuted;

        Task(int name, int count) {
            this.name = (char) name;
            this.count = count;
            this.lastExecuted = -1;
        }

        public int compareTo(Task other) {
            // Compare last executed first then count
            return other.count - this.count;
        }

        boolean canBeExecuted(int t, int n) {
            return lastExecuted == -1 || t - lastExecuted > n;
        }

        int execute(int t) {
            count--;
            lastExecuted = t;

            return count;
        }

        public String toString() {
            return "{name=" + name + ", count=" + count + ", lastExecuted=" + lastExecuted + "}";
        }
    }
}