// https://leetcode.com/problems/display-table-of-food-orders-in-a-restaurant
class Solution {
    public List<List<String>> displayTable(List<List<String>> orderList) {
        int id = 0;
        Set<String> food = new TreeSet<>();
        Map<String, Integer> foodId = new HashMap<>();
        Map<Integer, Map<Integer, Integer>> orders = new TreeMap<>();

        for (List<String> order: orderList) {
            String f = order.get(2);
            int t = Integer.parseInt(order.get(1));
            food.add(f);
            if (!foodId.containsKey(f)) foodId.put(f, id++);
            Map<Integer, Integer> map = orders.get(t);
            if (map == null) {
                map = new HashMap<>();
            }

            map.put(foodId.get(f), map.getOrDefault(foodId.get(f), 0) + 1);
            orders.put(t, map);
        }

        List<List<String>> res = new ArrayList<>();
        List<String> firstRow = new ArrayList<>();
        firstRow.add("Table");
        firstRow.addAll(food);
        res.add(firstRow);

        for (var e: orders.entrySet()) {
            int t = e.getKey();
            var map = e.getValue();
            List<String> row = new ArrayList<>();
            row.add(t + "");
            for (String f: food) {
                row.add("" + map.getOrDefault(foodId.get(f), 0));
            }

            res.add(row);
        }

        return res;
    }
}