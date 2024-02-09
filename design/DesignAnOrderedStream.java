// https://leetcode.com/problems/design-an-ordered-stream/
class OrderedStream {
    String[] data;
    int ptr;

    public OrderedStream(int n) {
        data = new String[n];
    }

    public List<String> insert(int idKey, String value) {
        data[idKey - 1] = value;
        List<String> res = new ArrayList<>();
        for (; ptr < data.length && data[ptr] != null; ptr++) {
            res.add(data[ptr]);
        }

        return res;
    }
}

/**
 * Your OrderedStream object will be instantiated and called as such:
 * OrderedStream obj = new OrderedStream(n);
 * List<String> param_1 = obj.insert(idKey,value);
 */