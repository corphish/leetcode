class Facebook {

    Map<Integer, List<Post>> posts = new HashMap<>();
    Map<Integer, Set<Integer>> friends = new HashMap<>();
    int ts = 0;

    public Facebook() {
        
    }
    
    public void writePost(int userId, String postContent) {
        posts.computeIfAbsent(userId, x -> new ArrayList<>()).add(new Post(postContent, ts++));
    }
    
    public void addFriend(int user1, int user2) {
        friends.computeIfAbsent(user1, x -> new HashSet<>()).add(user2);
        friends.computeIfAbsent(user2, x -> new HashSet<>()).add(user1);
    }
    
    public List<String> showPosts(int userId) {
        List<Post> res = new ArrayList<>();

        Set<Integer> list = friends.get(userId);
        if (list != null) {
            for (int friend: list) {
                res.addAll(posts.getOrDefault(friend, new ArrayList<>()));
            }
        }

        return res.stream().sorted().map(x -> x.content).collect(Collectors.toList());
    }

    class Post implements Comparable<Post> {
        String content;
        int ts;

        Post(String content, int ts) {
            this.content = content;
            this.ts = ts;
        }

        public int compareTo(Post other) {
            return other.ts - this.ts;
        }
    }
}

/**
 * Your Facebook object will be instantiated and called as such:
 * Facebook obj = new Facebook();
 * obj.writePost(userId,postContent);
 * obj.addFriend(user1,user2);
 * List<String> param_3 = obj.showPosts(userId);
 */