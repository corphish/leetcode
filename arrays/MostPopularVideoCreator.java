// https://leetcode.com/problems/most-popular-video-creator/
class Solution {
    public List<List<String>> mostPopularCreator(String[] creators, String[] ids, int[] view) {
        Map<String, Long> views = new HashMap<>();
        Map<String, TreeSet<Video>> videos = new HashMap<>();

        for (int i = 0; i < ids.length; i++) {
            views.put(creators[i], views.getOrDefault(creators[i], 0L) + view[i]);
            videos.computeIfAbsent(creators[i], x -> new TreeSet<>()).add(new Video(view[i], ids[i]));
        }

        long max = 0;
        List<String> maxPeople = new ArrayList<>();

        for (var e: views.entrySet()) {
            if (e.getValue() > max) {
                max = e.getValue();
                maxPeople.clear();
                maxPeople.add(e.getKey());
            } else if (e.getValue() == max) {
                maxPeople.add(e.getKey());
            }
        }

        List<List<String>> res = new ArrayList<>();
        for (String people: maxPeople) {
            res.add(List.of(people, videos.get(people).first().name));
        }

        return res;
    }

    class Video implements Comparable<Video> {
        int view;
        String name;

        Video(int view, String name) {
            this.view = view;
            this.name = name;
        }

        public int compareTo(Video other) {
            return this.view == other.view ? this.name.compareTo(other.name) : other.view - this.view;
        }
    }
}