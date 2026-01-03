package solutions.p811;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> countMap = new HashMap<>();

        for (String cp : cpdomains) {
            int space = cp.indexOf(' ');
            int visits = Integer.parseInt(cp.substring(0, space));
            String domain = cp.substring(space + 1);

            // count the domain and its subdomains
            String sub = domain;
            while (true) {
                countMap.put(sub, countMap.getOrDefault(sub, 0) + visits);
                int dot = sub.indexOf('.');
                if (dot == -1) break;
                sub = sub.substring(dot + 1);
            }
        }

        List<String> result = new ArrayList<>();
        for (Map.Entry<String, Integer> e : countMap.entrySet()) {
            result.add(e.getValue() + " " + e.getKey());
        }

        return result;
    }
}

