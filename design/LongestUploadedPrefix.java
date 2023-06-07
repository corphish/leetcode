// https://leetcode.com/problems/longest-uploaded-prefix
class LUPrefix {
    boolean[] used;
    int longest = 0;

    public LUPrefix(int n) {
        used = new boolean[n + 1];
    }
    
    public void upload(int video) {
        used[video] = true;
    }
    
    public int longest() {
        int len = longest;
        for (int i = longest + 1; i < used.length; i++, len++) {
            if (!used[i]) {
                break;
            }
        }

        longest = len;

        return len;
    }
}

/**
 * Your LUPrefix object will be instantiated and called as such:
 * LUPrefix obj = new LUPrefix(n);
 * obj.upload(video);
 * int param_2 = obj.longest();
 */