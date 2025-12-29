import java.util.*;

class Solution {
    Map<String, List<Character>> map = new HashMap<>();

    public boolean pyramidTransition(String bottom, List<String> allowed) {
        for (String s : allowed) {
            String key = s.substring(0, 2);
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(s.charAt(2));
        }
        return dfs(bottom);
    }

    private boolean dfs(String cur) {
        if (cur.length() == 1) return true;
        return build(cur, 0, new StringBuilder());
    }

    private boolean build(String cur, int idx, StringBuilder next) {
        if (idx == cur.length() - 1) return dfs(next.toString());

        String key = cur.substring(idx, idx + 2);
        if (!map.containsKey(key)) return false;

        for (char c : map.get(key)) {
            next.append(c);
            if (build(cur, idx + 1, next)) return true;
            next.deleteCharAt(next.length() - 1);
        }
        return false;
    }
}
