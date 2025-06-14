// https://leetcode.com/problems/sliding-window-median/
class Solution {
    public double[] medianSlidingWindow(int[] nums, int k) {
        OrderedWindow w = new OrderedWindow(k);
        double[] res = new double[nums.length - k + 1];
        int x = 0;

        for (int i = 0; i < nums.length; i++) {
            if (i >= k) {
                res[x++] = w.median();
                w.remove(nums[i - k]);
            }

            w.add(nums[i]);
        }

        res[x] = w.median();

        return res;
    }

    class OrderedWindow {
        final int size;
        final boolean log = false;
        private int xs = 0, ms = 0;
        TreeMap<Integer, Integer> min = new TreeMap<>(Collections.reverseOrder());
        TreeMap<Integer, Integer> max = new TreeMap<>();

        OrderedWindow(int size) {
            this.size = size;
        }

        void add(int x) {
            if (ms == 0) {
                min.put(x, min.getOrDefault(x, 0) + 1);
                ms += 1;
            } else if (xs == 0) {
                max.put(x, max.getOrDefault(x, 0) + 1);
                xs += 1;
            } else if (ms == xs) {
                // We add to min
                int maxTop = max.firstKey();
                if (x <= maxTop) {
                    min.put(x, min.getOrDefault(x, 0) + 1);
                    ms += 1;
                } else {
                    min.put(max.firstKey(), min.getOrDefault(max.firstKey(), 0) + 1);
                    ms += 1;
                    max.put(max.firstKey(), max.getOrDefault(max.firstKey(), 0) - 1);
                    xs -= 1;
                    clearKey(max, max.firstKey());
                    max.put(x, max.getOrDefault(x, 0) + 1);
                    xs += 1;
                }
            } else {
                // We add to max
                int minTop = min.firstKey();
                if (x >= minTop) {
                    max.put(x, max.getOrDefault(x, 0) + 1);
                    xs += 1;
                } else {
                    max.put(min.firstKey(), max.getOrDefault(min.firstKey(), 0) + 1);
                    xs += 1;
                    min.put(min.firstKey(), min.getOrDefault(min.firstKey(), 0) - 1);
                    ms -= 1;
                    clearKey(min, min.firstKey());
                    min.put(x, min.getOrDefault(x, 0) + 1);
                    ms += 1;
                }
            }

            if (log) {
                System.out.println("Add " + x);
                System.out.println(min + " -> " + ms);
                System.out.println(max + " -> " + xs);
            }
        }

        private void clearKey(TreeMap<Integer, Integer> map, int key) {
            if (map.getOrDefault(key, 0) <= 0) {
                map.remove(key);
            }
        }

        void remove(int x) {
            int minTop = min.firstKey();

            if (xs == 0) {
                min.put(x, min.getOrDefault(x, 0) - 1);
                ms -= 1;
                clearKey(min, x);
                return;
            }

            int maxTop = max.firstKey();

            // If mintop = maxtop = x
            if (minTop == x && maxTop == x) {
                if (ms == xs) {
                    max.put(x, max.getOrDefault(x, 0) - 1);
                    xs -= 1;
                    clearKey(max, x);
                } else {
                    min.put(x, min.getOrDefault(x, 0) - 1);
                    ms -= 1;
                    clearKey(min, x);
                }
            } else {
                if (x <= minTop) {
                    // We have to remove from min
                    if (ms == xs) {
                        min.put(max.firstKey(), min.getOrDefault(max.firstKey(), 0) + 1);
                        ms += 1;
                        max.put(max.firstKey(), max.getOrDefault(max.firstKey(), 0) - 1);
                        xs -= 1;
                        clearKey(max, max.firstKey());
                        min.put(x, min.getOrDefault(x, 0) - 1);
                        ms -= 1;
                        clearKey(min, x);
                    } else {
                        min.put(x, min.getOrDefault(x, 0) - 1);
                        ms -= 1;
                        clearKey(min, x);
                    }
                } else if (x >= maxTop) {
                    // We have to remove from max
                    if (ms == xs) {
                        max.put(x, max.getOrDefault(x, 0) - 1);
                        xs -= 1;
                        clearKey(max, x);
                    } else {
                        max.put(min.firstKey(), max.getOrDefault(min.firstKey(), 0) + 1);
                        xs += 1;
                        min.put(min.firstKey(), min.getOrDefault(min.firstKey(), 0) - 1);
                        ms -= 1;
                        clearKey(min, min.firstKey());
                        max.put(x, max.getOrDefault(x, 0) - 1);
                        xs -= 1;
                        clearKey(max, x);
                    }
                } else {
                    if (log) {
                        System.out.println("Element not found");
                    }
                }
            }

            if (log) {
                System.out.println("Remove " + x);
                System.out.println(min + " -> " + ms);
                System.out.println(max + " -> " + xs);
            }
        }

        double median() {
            int m = min.firstKey();

            if (max.size() == 0) {
                return m;
            }

            int x = max.firstKey();
            if (log) {
                System.out.println("================");
                System.out.println(m);
                System.out.println(x);
            }

            return size % 2 == 1 ? m : (m * 1.0 + x) / 2;
        }
    }
}