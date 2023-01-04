// https://leetcode.com/problems/subdomain-visit-count/
class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> freq = new HashMap<>();
        for (String domain: cpdomains) {
            String[] parts = domain.split(" ");
            int count = Integer.parseInt(parts[0]);
            while (!parts[1].isEmpty()) {
                freq.put(parts[1], freq.getOrDefault(parts[1], 0) + count);
                int index = parts[1].indexOf(".");
                if (index < 0) parts[1] = "";
                else parts[1] = parts[1].substring(index + 1);
            }
        }

        return freq.entrySet()
                .stream()
                .map(x -> x.getValue() + " " + x.getKey())
                .collect(Collectors.toList());

    }
}