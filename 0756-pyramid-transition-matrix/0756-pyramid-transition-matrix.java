import java.util.*;

class Solution {
    int[][] trans = new int[7][7];
    boolean dfs(int[] row, int len) {
        if (len == 1) return true;
        int[] next = new int[len - 1];
        return build(row, next, 0, len);
    }
    boolean build(int[] row, int[] next, int idx, int len) {
        if (idx == len - 1) return dfs(next, len - 1);
        int mask = trans[row[idx]][row[idx + 1]];
        while (mask != 0) {
            int bit = mask & -mask;
            next[idx] = Integer.numberOfTrailingZeros(bit);
            if (build(row, next, idx + 1, len)) return true;
            mask -= bit;
        }
        return false;
    }
    public boolean pyramidTransition(String bottom, List<String> allowed) {
        for (String s : allowed) {
            int a = s.charAt(0) - 'A';
            int b = s.charAt(1) - 'A';
            int c = s.charAt(2) - 'A';
            trans[a][b] |= 1 << c;
        }
        int n = bottom.length();
        int[] row = new int[n];
        for (int i = 0; i < n; i++) row[i] = bottom.charAt(i) - 'A';
        return dfs(row, n);
    }
}
